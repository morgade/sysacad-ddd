package org.morgade.sysacad.domain.model.disciplina;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.ObjectUtils;
import org.morgade.sysacad.domain.shared.Entity;


/**
 *
 * @author x4rb
 */
@javax.persistence.Entity
@Table(name = "Disciplina", schema = "app")
public class Disciplina implements Entity<Disciplina> {
    @Id
    @Column(name = "disc_cd_disciplina")
    private String codigo;
    @Column(name = "disc_nm_disciplina")
    private String nome;

    /**
     * Exigido pelo Hibernate
     */
    Disciplina() {
    }

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public boolean sameIdentityAs(Disciplina other) {
        return other != null && ObjectUtils.equals(codigo, other.getCodigo());
    }
}
