package org.morgade.sysacad.application.impl;

import java.util.List;
import org.morgade.sysacad.application.CatalogoService;
import org.morgade.sysacad.application.dto.AlunoDTO;
import org.morgade.sysacad.domain.shared.Assembler;
import org.morgade.sysacad.application.dto.CursoDTO;
import org.morgade.sysacad.application.dto.DisciplinaDTO;
import org.morgade.sysacad.application.dto.TurmaBaseDTO;
import org.morgade.sysacad.application.dto.TurmaDTO;
import org.morgade.sysacad.domain.model.aluno.Aluno;
import org.morgade.sysacad.domain.model.aluno.AlunoRepository;
import org.morgade.sysacad.domain.model.curso.Curso;
import org.morgade.sysacad.domain.model.curso.CursoRepository;
import org.morgade.sysacad.domain.model.disciplina.Disciplina;
import org.morgade.sysacad.domain.model.disciplina.DisciplinaRepository;
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
public class CatalogoServiceImpl implements CatalogoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private Assembler assembler;

    @Override
    @Transactional()
    public List<AlunoDTO> buscarAlunos() {
        List<Aluno> l = alunoRepository.buscar();
        return assembler.from(l, AlunoDTO.class);
    }

    @Override
    @Transactional()
    public List<CursoDTO> buscarCursos() {
        List<Curso> l = cursoRepository.buscar();
        return assembler.from(l, CursoDTO.class);
    }

    @Override
    @Transactional()
    public List<DisciplinaDTO> buscarDisciplinas() {
        List<Disciplina> l = disciplinaRepository.buscar();
        return assembler.from(l, DisciplinaDTO.class);
    }

    @Override
    @Transactional()
    public List<TurmaBaseDTO> buscarTurmas(String codigoDisciplina) {
        List<Turma> l = disciplinaRepository.buscarTurmas(codigoDisciplina);
        return assembler.from(l, TurmaBaseDTO.class);
    }

    @Override
    @Transactional()
    public TurmaDTO buscarTurma(Long idTurma) {
        Turma t = turmaRepository.obter(idTurma);
        return assembler.from(t, TurmaDTO.class);
    }
    
}
