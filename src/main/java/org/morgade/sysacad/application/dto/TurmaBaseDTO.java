package org.morgade.sysacad.application.dto;

/**
 *
 * @author x4rb
 */
public class TurmaBaseDTO {
    private Long id;
    private String codigo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
