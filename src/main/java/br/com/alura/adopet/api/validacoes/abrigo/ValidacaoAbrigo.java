package br.com.alura.adopet.api.validacoes.abrigo;

import br.com.alura.adopet.api.dto.DadosCadastroAbrigoDto;

public interface ValidacaoAbrigo {

    void validar(DadosCadastroAbrigoDto dto);
}
