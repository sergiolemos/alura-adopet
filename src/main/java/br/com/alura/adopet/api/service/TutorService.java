package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.DadosAtualizarTutorDto;
import br.com.alura.adopet.api.dto.DadosCadastroTutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public void cadastrar(DadosCadastroTutorDto dto) {
        boolean jaCadastrado = tutorRepository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoException("Telefone/Email já possuem cadastro");
        }
        tutorRepository.save(new Tutor(dto));
    }

    public void atualizar(DadosAtualizarTutorDto dto) {
        Tutor tutor = tutorRepository.getReferenceById(dto.id());
        if (tutor == null) {
            throw new ValidacaoException("Tutor não localizado");
        }
        tutor.atualizarDados(dto);

    }
}
