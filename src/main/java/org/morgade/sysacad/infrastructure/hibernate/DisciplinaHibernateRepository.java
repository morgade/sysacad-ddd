package org.morgade.sysacad.infrastructure.hibernate;

import java.util.List;
import org.morgade.sysacad.domain.model.disciplina.Disciplina;
import org.morgade.sysacad.domain.model.disciplina.DisciplinaRepository;
import org.morgade.sysacad.domain.model.turma.Turma;
import org.morgade.sysacad.infrastructure.hibernate.shared.HibernateRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author x4rb
 */
@Repository
public class DisciplinaHibernateRepository extends HibernateRepository<Disciplina, String> implements DisciplinaRepository {

    public DisciplinaHibernateRepository() {
        super(Disciplina.class);
    }

    @Override
    public List<Turma> buscarTurmas(String codigoDisciplina) {
        return getSession().createQuery("select t from Turma t where t.disciplina.codigo = :codigoDisciplina").setParameter("codigoDisciplina", codigoDisciplina).list();
    }

}
