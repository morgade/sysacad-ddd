package org.morgade.sysacad.infrastructure.spring.assembler.converter;

import org.morgade.sysacad.application.Assembler;
import org.morgade.sysacad.application.dto.AlunoDTO;
import org.morgade.sysacad.application.dto.InscricaoDTO;
import org.morgade.sysacad.domain.model.turma.Inscricao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author x4rb
 */
@Component
public class InscricaoParaInscricaoDTO implements Converter<Inscricao, InscricaoDTO>{
    @Autowired
    private Assembler assembler;
    
    @Override
    public InscricaoDTO convert(Inscricao source) {
        InscricaoDTO i = new InscricaoDTO();
        i.setId(source.getId());
        i.setAluno(assembler.from(source.getAluno(), AlunoDTO.class));
        i.setStatus(source.getStatus());
        i.setData(source.getData());
        return i;
    }
    
}
