package org.morgade.sysacad.infrastructure.hibernate.shared;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Specificação de query
 * @param <T>
 */
public abstract class HibernateQuerySpecification<T extends Serializable>  {
    protected final StringBuilder text = new StringBuilder();
    protected final Map<String, Object> params = new HashMap<>();

    public String getText() {
        return text.toString();
    }

    public Map<String, Object> getParams() {
        return params;
    }
}