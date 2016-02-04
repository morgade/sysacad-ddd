package org.morgade.sysacad.domain.model.turma;

import org.morgade.sysacad.domain.shared.ValueObject;

/**
 *
 * @author x4rb
 */
public enum Turno implements ValueObject<Turno> {
    MATUTINO,
    VESPETINO,
    NOTURNO;

    @Override
    public boolean sameValueAs(Turno other) {
        return other == this;
    }
}
