package org.morgade.sysacad.domain.model.disciplina;

import java.util.List;
import org.morgade.sysacad.domain.model.turma.Turma;

/**
 *
 * @author x4rb
 */
public interface DisciplinaRepository {
    Disciplina obter(String codigo);
    List<Disciplina> buscar();
    List<Turma> buscarTurmas(String codigoDisciplina);
}