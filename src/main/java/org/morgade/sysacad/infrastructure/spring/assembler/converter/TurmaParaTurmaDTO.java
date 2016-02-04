package org.morgade.sysacad.infrastructure.spring.assembler.converter;

import java.util.ArrayList;
import org.morgade.sysacad.application.Assembler;
import org.morgade.sysacad.application.dto.InscricaoDTO;
import org.morgade.sysacad.application.dto.TurmaDTO;
import org.morgade.sysacad.domain.model.turma.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author x4rb
 */
@Component
public class TurmaParaTurmaDTO implements Converter<Turma, TurmaDTO>{
    @Autowired
    private Assembler assembler;
    
    @Override
    public TurmaDTO convert(Turma source) {
        TurmaDTO t = new TurmaDTO();
        t.setId(source.getId());
        t.setCodigo(source.getCodigo());
        t.setNomeProfessor(source.getProfessor().getNome());
        t.setVagas(source.getVagas());
        t.setVagasOcupadas(source.vagasOcupadas());
        t.setPeriodo(source.getPeriodo());
        t.setTurno(source.getTurno());
        t.setInscricoes(new ArrayList(assembler.from(source.getInscricoes(), InscricaoDTO.class)));
        return t;
    }
    
}
