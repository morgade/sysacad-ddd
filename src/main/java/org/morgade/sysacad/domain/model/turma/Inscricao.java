package org.morgade.sysacad.domain.model.turma;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.morgade.sysacad.domain.model.aluno.Aluno;
import org.morgade.sysacad.domain.shared.Entity;

/**
 *
 * @author x4rb
 */
@javax.persistence.Entity
public class Inscricao implements Entity<Inscricao> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insc_cd_inscricao")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alun_cd_aluno")
    private Aluno aluno;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "INSC_DT_INSCRICAO")
    private Date data;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "insc_in_status")
    private Status status;
    
    /**
     * Exigido pelo Hibernate
     */
    Inscricao() {
    }
    
    public Inscricao(Aluno aluno) {
        Validate.notNull(aluno, "Aluno deve ser definido");
        this.aluno = aluno;
        this.data = new Date();
        this.status = Status.PENDENTE;
    }
    
    protected void aprovar() {
        Validate.isTrue(this.status==Status.PENDENTE, "Só é possível aprovar uma inscrição pendente");
        this.status = Status.CONFIRMADA;
    }
    
    protected void reprovar() {
        Validate.isTrue(this.status==Status.PENDENTE, "Só é possível reprovar uma inscrição pendente");
        this.status = Status.CANCELADA;
    }

    public Long getId() {
        return id;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public Status getStatus() {
        return status;
    }

    public Date getData() {
        return data;
    }
    
    
    @Override
    public boolean sameIdentityAs(Inscricao other) {
        return other != null && ObjectUtils.equals(id, other.id);
    }
    
}
