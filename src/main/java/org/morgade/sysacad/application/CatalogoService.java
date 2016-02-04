package org.morgade.sysacad.application;

import java.util.List;
import org.morgade.sysacad.application.dto.AlunoDTO;
import org.morgade.sysacad.application.dto.CursoDTO;
import org.morgade.sysacad.application.dto.DisciplinaDTO;
import org.morgade.sysacad.application.dto.TurmaBaseDTO;
import org.morgade.sysacad.application.dto.TurmaDTO;

/**
 *
 * @author x4rb
 */
public interface CatalogoService {
    List<AlunoDTO> buscarAlunos();
    List<CursoDTO> buscarCursos();
    List<DisciplinaDTO> buscarDisciplinas();
    List<TurmaBaseDTO> buscarTurmas(String codigoDisciplina);
    TurmaDTO buscarTurma(Long idTurma);
}
