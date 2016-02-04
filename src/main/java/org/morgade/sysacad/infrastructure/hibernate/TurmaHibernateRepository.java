package org.morgade.sysacad.infrastructure.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.morgade.sysacad.domain.model.turma.Turma;
import org.morgade.sysacad.domain.model.turma.TurmaRepository;
import org.morgade.sysacad.infrastructure.hibernate.shared.HibernateRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author x4rb
 */
@Repository
public class TurmaHibernateRepository extends HibernateRepository<Turma, Long> implements TurmaRepository {

    public TurmaHibernateRepository() {
        super(Turma.class);
    }

    @Override
    public List<Turma> buscarTurmasInscritas(Long matricula) {
        Query q = getSession().createQuery("select t from Turma t join fetch t.disciplina join fetch t.professor where exisists(t.inscricoes[:matricula])");
        q.setParameter("matricula", matricula);
        return q.list();
    }
    
}
