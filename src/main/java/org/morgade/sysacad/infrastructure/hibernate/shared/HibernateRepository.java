package org.morgade.sysacad.infrastructure.hibernate.shared;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.morgade.sysacad.domain.shared.Entity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author x4rb
 * @param <E>
 * @param <I>
 */
public class HibernateRepository<E extends Entity, I extends Serializable> {
    @Autowired
    private SessionFactory sessionFactory;
    private final Class<E> clazz;

    public HibernateRepository(Class<E> clazz) {
        this.clazz = clazz;
    }
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    protected Query createHibernateQuery(HibernateQuerySpecification querySpec) {
        Query query = getSession().createQuery(querySpec.getText());
        Map<String, Object> params = querySpec.getParams();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        return query;
    }
    
    public List<E> buscar() {
        return getSession().createCriteria(clazz).list();
    }
    
    public E obter(I id) {
        return (E) getSession().get(clazz, id);
    }
    
    public void remover(E e) {
        getSession().delete(e);
    }
    
    public void armazenar(E e) {
        getSession().persist(e);
    }
}
