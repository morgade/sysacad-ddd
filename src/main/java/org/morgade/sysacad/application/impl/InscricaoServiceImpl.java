package org.morgade.sysacad.application.impl;

import org.morgade.sysacad.application.InscricaoService;
import org.morgade.sysacad.domain.model.aluno.Aluno;
import org.morgade.sysacad.domain.model.aluno.AlunoRepository;
import org.morgade.sysacad.domain.model.turma.Turma;
import org.morgade.sysacad.domain.model.turma.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author x4rb
 */
@Service
public class InscricaoServiceImpl implements InscricaoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaRepository turmaRepository;
    
    @Override
    @Transactional(readOnly = false)
    public void inscrever(Long matricula, Long idTurma) {
        Turma turma = turmaRepository.obter(idTurma);
        Aluno aluno = alunoRepository.obter(matricula);
        turma.inscrever(aluno);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void aprovarInscricao(Long matricula, Long idTurma) {
        Turma turma = turmaRepository.obter(idTurma);
        turma.aprovarInscricao(matricula);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void reprovarInscricao(Long matricula, Long idTurma) {
        Turma turma = turmaRepository.obter(idTurma);
        turma.reprovarInscricao(matricula);
    }

}
