package org.morgade.sysacad.domain.model.professor;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.morgade.sysacad.domain.shared.Entity;

/**
 *
 * @author x4rb
 */
@javax.persistence.Entity
public class Professor implements Entity<Professor>  {
    @Id
    @Column(name="prof_cd_professor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="prof_nm_professor")
    private String nome;
    
//    @ElementCollection
//    private Set<Contato> contatos;

    /**
     * Exigido pelo Hibernate
     */
    Professor() {
    }

    public Professor(String nome) {
        Validate.notBlank(nome, "Nome do professor não deve ser vazio");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    @Override
    public boolean sameIdentityAs(Professor other) {
        return other != null && ObjectUtils.equals(id, other.id);
    }
    
}
