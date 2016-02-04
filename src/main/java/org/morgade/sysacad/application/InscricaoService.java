package org.morgade.sysacad.application;

/**
 *
 * @author x4rb
 */
public interface InscricaoService {
    void inscrever(Long matricula, Long idTurma);
    void aprovarInscricao(Long matricula, Long idTurma);
    void reprovarInscricao(Long matricula, Long idTurma);
}
