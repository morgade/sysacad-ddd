package org.morgade.sysacad.application.dto;

import java.util.List;
import org.morgade.sysacad.domain.model.turma.Periodo;
import org.morgade.sysacad.domain.model.turma.Turno;


/**
 *
 * @author x4rb
 */
public class TurmaDTO {
    private Long id;
    private String codigo;
    private String nomeProfessor;
    private Integer vagas;
    private Integer vagasOcupadas;
    private Periodo periodo;
    private Turno turno;
    private List<InscricaoDTO> inscricoes;

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

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Integer getVagasOcupadas() {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(Integer vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public List<InscricaoDTO> getInscricoes() {
        return inscricoes;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public void setInscricoes(List<InscricaoDTO> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
}
