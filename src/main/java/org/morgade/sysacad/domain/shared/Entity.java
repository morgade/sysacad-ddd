package org.morgade.sysacad.domain.shared;

/**
 *
 * @author x4rb
 */
public interface Entity<T> {

  boolean sameIdentityAs(T other);

}
