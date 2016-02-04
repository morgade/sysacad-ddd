package org.morgade.sysacad.infrastructure.hibernate;

import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.morgade.sysacad.domain.model.aluno.Aluno;
import org.morgade.sysacad.domain.model.aluno.AlunoRepository;
import org.morgade.sysacad.infrastructure.hibernate.shared.HibernateRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author x4rb
 */
@Repository
public class AlunoHibernateRepository extends HibernateRepository<Aluno, Long> implements AlunoRepository {

    public AlunoHibernateRepository() {
        super(Aluno.class);
    }
    
}
