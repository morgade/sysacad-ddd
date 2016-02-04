package org.morgade.sysacad.domain.model.turma;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.morgade.sysacad.domain.model.professor.Professor;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.morgade.sysacad.domain.model.aluno.Aluno;
import org.morgade.sysacad.domain.model.disciplina.Disciplina;
import org.morgade.sysacad.domain.shared.Entity;

/**
 *
 * @author x4rb
 */
@javax.persistence.Entity
@Table(name="Turma", schema="app")
public class Turma implements Entity<Turma> {
    @Id
    @Column(name="turm_cd_turma")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disc_cd_disciplina", referencedColumnName = "disc_cd_disciplina")
    private Disciplina disciplina;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof_cd_professor", referencedColumnName = "prof_cd_professor")
    private Professor professor;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapKeyColumn(name = "alun_cd_aluno", nullable = false)
    @JoinColumn(name = "turm_cd_turma", nullable = false )
    private Map<Long, Inscricao> inscricoes;
    
    @Column(name="turm_nr_vagas")
    private Integer vagas;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "turm_in_turno")
    private Turno turno;
    
    @Embedded
    private Periodo periodo;

    /**
     * Exigido pelo Hibernate
     */
    Turma() {
    }
    
    public Turma(Disciplina disciplina) {
        Validate.notNull(disciplina, "A disciplina deve ser definida");
        this.disciplina = disciplina;
        this.inscricoes = new HashMap<>();
        this.turno = Turno.MATUTINO;
    }
    
    public Inscricao inscrever(Aluno aluno) {
        Validate.notNull(aluno, "Aluno não definido para inscrição");
        Validate.isTrue(this.vagasDisponiveis() > 0, "Não existem mais vagas disponíveis na turma");
        Validate.isTrue(!inscricoes.containsKey(aluno.getMatricula()), "O aluno já tem uma matricula nesta turma");
        Inscricao i = new Inscricao(aluno);
        inscricoes.put(aluno.getMatricula(), i);
        return i;
    }
    
    public void aprovarInscricao(Long matriculaAluno) {
        inscricoes.get(matriculaAluno).aprovar();
        
    }
    
    public void reprovarInscricao(Long matriculaAluno) {
        inscricoes.get(matriculaAluno).reprovar();
    }
    
    public int vagasOcupadas() {
        int i = 0;
        for (Inscricao inscricao : this.inscricoes.values()) {
            if (inscricao.getStatus()!=Status.CANCELADA) {
                i++;
            }
        }
        
        return i;
    }
    public int vagasDisponiveis() {
        return this.vagas - this.vagasOcupadas();
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return disciplina.getCodigo()+'-'+id;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Integer getVagas() {
        return vagas;
    }

    public Turno getTurno() {
        return turno;
    }
    
    
    public Collection<Inscricao> getInscricoes() {
        return Collections.unmodifiableCollection(inscricoes.values());
    }

    @Override
    public boolean sameIdentityAs(Turma other) {
        return other != null && ObjectUtils.equals(id, other.id);
    }
    
}
