package org.morgade.sysacad.domain.model.curso;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.morgade.sysacad.domain.model.disciplina.Disciplina;
import org.morgade.sysacad.domain.shared.Entity;

/**
 *
 * @author x4rb
 */
@javax.persistence.Entity
@Table(name = "Curso", schema = "app")
public class Curso implements Entity<Curso> {
    @Id
    @Column(name = "curs_cd_curso")
    private Long id;
    
    @Column(name = "curs_nm_curso")
    private String nome;
    
    @Column(name = "curs_tx_descricao")
    private String descricao;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Curso_Disciplina", schema = "app", 
            joinColumns = { @JoinColumn(name = "disc_cd_disciplina") }, 
            inverseJoinColumns = {@JoinColumn(name = "curs_cd_curso") }
    )
    private Set<Disciplina> curriculo;

    /**
     * Exigido pelo Hibernate
     */
    Curso() {
    }
    
    public Curso(String nome) {
        Validate.notBlank(nome, "Nome do curso não deve ser vazio");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public boolean sameIdentityAs(Curso other) {
        return other != null && ObjectUtils.equals(id, other.id);
    }
}
