package org.morgade.sysacad.application.dto;

import java.util.Date;
import org.morgade.sysacad.domain.model.turma.Status;

/**
 *
 * @author x4rb
 */
public class InscricaoDTO {
    private Long id;
    private AlunoDTO aluno;
    private Date data;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}
