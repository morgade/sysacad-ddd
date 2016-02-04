package org.morgade.sysacad.domain.model.curso;

import java.util.List;

/**
 *
 * @author x4rb
 */
public interface CursoRepository {
    Curso obter(Long id);
    List<Curso> buscar();
}
