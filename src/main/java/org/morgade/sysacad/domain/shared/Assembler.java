package org.morgade.sysacad.domain.shared;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author x4rb
 */
public interface Assembler {
    <S, T> T from(S source, Class<T> targetClass);
    <S, T> List<T> from(List<S> list, Class<T> targetClass);
    <S, T> Collection<T> from(Collection<S> list, Class<T> targetClass);
}
