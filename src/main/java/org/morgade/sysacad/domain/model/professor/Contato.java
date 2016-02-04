package org.morgade.sysacad.domain.model.professor;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.morgade.sysacad.domain.shared.ValueObject;

/**
 *
 * @author x4rb
 */
public class Contato implements ValueObject<Contato>{
    private final String telefone;

    public Contato(String telefone) {
        Validate.notBlank(telefone, "O telefone deve ter um conteúdo");
        this.telefone = telefone;
    }
    
    public String getTelefone() {
        return telefone;
    }

    @Override
    public boolean sameValueAs(Contato other) {
        return other != null && ObjectUtils.equals(telefone, other.telefone);
    }
    
    
}
