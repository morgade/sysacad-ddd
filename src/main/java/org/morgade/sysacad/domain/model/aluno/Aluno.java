package org.morgade.sysacad.domain.model.aluno;

import org.morgade.sysacad.domain.model.curso.Curso;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.morgade.sysacad.domain.shared.Entity;

/**
 *
 * @author x4rb
 */
@javax.persistence.Entity
@Table(name="Aluno", schema="app")
public class Aluno implements Entity<Aluno> {
    @Id
    @Column(name="alun_cd_aluno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;
    
    @Column(name="alun_nm_aluno")
    private String nome;
    
    @Column(name="alun_dt_nascimento")
    private Date nascimento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curs_cd_curso", referencedColumnName = "curs_cd_curso")
    private Curso curso;

    /**
     * Exigido pelo Hibernate
     */
    Aluno() {
    }

    public Aluno(String nome) {
        Validate.notBlank(nome, "Nome do curso não deve ser vazio");
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean sameIdentityAs(Aluno other) {
        return other != null && ObjectUtils.equals(matricula, other.getMatricula());
    }
    
}
