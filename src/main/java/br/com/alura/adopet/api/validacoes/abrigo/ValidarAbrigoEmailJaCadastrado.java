package br.com.alura.adopet.api.validacoes.abrigo;

import br.com.alura.adopet.api.dto.DadosCadastroAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidarAbrigoEmailJaCadastrado implements ValidacaoAbrigo {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Override
    public void validar(DadosCadastroAbrigoDto dto) {
        boolean emailJaCadastrado = abrigoRepository.existsByEmail(dto.email());
        if (emailJaCadastrado) {
            throw new ValidacaoException("E-mail do abrigo já cadastrado");
        }
    }
}
