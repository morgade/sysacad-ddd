package org.morgade.sysacad.infrastructure.spring.assembler.converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.morgade.sysacad.application.dto.AlunoDTO;
import org.morgade.sysacad.application.dto.CursoDTO;
import org.morgade.sysacad.application.dto.DisciplinaDTO;
import org.morgade.sysacad.application.dto.TurmaBaseDTO;
import org.morgade.sysacad.domain.model.aluno.Aluno;
import org.morgade.sysacad.domain.model.curso.Curso;
import org.morgade.sysacad.domain.model.disciplina.Disciplina;
import org.morgade.sysacad.domain.model.turma.Turma;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

/**
 *
 * @author x4rb
 */
@Component
public class DirectMapConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return new HashSet<>(Arrays.asList(
                new ConvertiblePair(Aluno.class, AlunoDTO.class),
                new ConvertiblePair(Curso.class, CursoDTO.class),
                new ConvertiblePair(Turma.class, TurmaBaseDTO.class),
                new ConvertiblePair(Disciplina.class, DisciplinaDTO.class)
        ));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = BeanUtils.instantiate(targetType.getType());
        BeanUtils.copyProperties(source, target);
        return target;
    }
    
}
