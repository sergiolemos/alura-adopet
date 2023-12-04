package br.com.alura.adopet.api.validacoes.abrigo;

import br.com.alura.adopet.api.dto.DadosCadastroAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidarAbrigoNomeJaCadastrado implements ValidacaoAbrigo {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Override
    public void validar(DadosCadastroAbrigoDto dto) {
        boolean nomeJaCadastrado = abrigoRepository.existsByNome(dto.nome());
        if (nomeJaCadastrado) {
            throw new ValidacaoException("Nome do abrigo já cadastrado");
        }
    }
}
