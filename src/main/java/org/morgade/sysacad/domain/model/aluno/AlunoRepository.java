package org.morgade.sysacad.domain.model.aluno;

import java.util.List;

/**
 *
 * @author x4rb
 */
public interface AlunoRepository {
    Aluno obter(Long matricula);
    List<Aluno> buscar();
}
