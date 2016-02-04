package org.morgade.sysacad.infrastructure.hibernate;

import org.morgade.sysacad.domain.model.curso.Curso;
import org.morgade.sysacad.domain.model.curso.CursoRepository;
import org.morgade.sysacad.infrastructure.hibernate.shared.HibernateRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author x4rb
 */
@Repository
public class CursoHibernateRepository extends HibernateRepository<Curso, Long> implements CursoRepository {

    public CursoHibernateRepository() {
        super(Curso.class);
    }

    
}
