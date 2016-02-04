package org.morgade.sysacad.infrastructure.spring;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;

/**
 *
 * @author x4rb
 */
public class DelegationInterceptor implements MethodInterceptor, BeanFactoryAware {
    private ListableBeanFactory beanFactory;


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        // Obtém a interface de declaração do método
        Class methodInterface = mi.getMethod().getDeclaringClass();
        // Busca o delegate responsável
        Set<Object> beanSet = new HashSet( beanFactory.getBeansOfType(methodInterface).values() );
        beanSet.remove(((ReflectiveMethodInvocation) mi).getProxy());
        
                
        if (beanSet.isEmpty()) {
            throw new IllegalStateException("Nenhum bean compatível com o tipo "+methodInterface+" encontrado para delegar a chamada ao método "+ mi.getMethod().getName());
        } else if (beanSet.size()>1) {
            throw new IllegalStateException("Mais de 1 bean compatível com o tipo "+methodInterface+" encontrado para delegar a chamada ao método "+ mi.getMethod().getName());
        } else {
            Object delegate = beanSet.iterator().next();
            // Obtém a implementação do método
            Method delegateMethod = delegate.getClass().getMethod(mi.getMethod().getName(), mi.getMethod().getParameterTypes());
            // Invoca o método no delegate responsável
            return delegateMethod.invoke(delegate, mi.getArguments());
        }
    }

    @Override
    public void setBeanFactory(BeanFactory factory) {
        beanFactory = ((ListableBeanFactory)factory);
    }

}

