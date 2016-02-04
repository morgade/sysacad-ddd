package org.morgade.sysacad.domain.model.turma;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import org.apache.commons.lang3.ObjectUtils;
import org.morgade.sysacad.domain.shared.ValueObject;

/**
 *
 * @author x4rb
 */
@Embeddable
public class Periodo implements ValueObject<Periodo> {
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="turm_dt_periodo_inicio")
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="turm_dt_periodo_fim")
    private Date fim;

    /**
     * Exigido pelo Hibernate
     */
    Periodo() {
    }
    
    public Periodo(Date inicio, Date fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    @Override
    public boolean sameValueAs(Periodo other) {
        return other != null && ObjectUtils.equals(other.inicio, inicio) && ObjectUtils.equals(other.fim, fim);
    }
    
}
