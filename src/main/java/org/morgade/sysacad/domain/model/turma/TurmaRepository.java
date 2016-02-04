package org.morgade.sysacad.domain.model.turma;

import java.util.List;

/**
 *
 * @author x4rb
 */
public interface TurmaRepository {
    Turma obter(Long codigo);
    List<Turma> buscarTurmasInscritas(Long matricula);
}
