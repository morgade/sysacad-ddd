package org.morgade.sysacad.application.dto;

/**
 *
 * @author x4rb
 */
public class AlunoDTO {
    private Long matricula;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    
}
