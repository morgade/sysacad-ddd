package org.morgade.sysacad.domain.model.turma;

import org.morgade.sysacad.domain.shared.ValueObject;

/**
 *
 * @author x4rb
 */
public enum Status implements ValueObject<Status> {
    PENDENTE,
    CANCELADA,
    CONFIRMADA;

    @Override
    public boolean sameValueAs(Status other) {
        return other == this;
    }
}
