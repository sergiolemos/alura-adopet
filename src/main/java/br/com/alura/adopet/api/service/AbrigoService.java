package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.DadosCadastroAbrigoDto;
import br.com.alura.adopet.api.dto.DadosCadastroPetDto;
import br.com.alura.adopet.api.dto.DadosDetalheAbrigoDto;
import br.com.alura.adopet.api.dto.DadosDetalhesPetDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.validacoes.abrigo.ValidacaoAbrigo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;
    @Autowired
    private PetRepository petRepository;
    private List<ValidacaoAbrigo> validacoes;

    public List<DadosDetalheAbrigoDto> listar() {
        return abrigoRepository.findAll()
                .stream()
                .map(DadosDetalheAbrigoDto::new)
                .toList();
    }

    public void cadastrar(DadosCadastroAbrigoDto dto) {
        validacoes.forEach(v -> v.validar(dto));
        abrigoRepository.save(new Abrigo(dto));
    }


    public List<DadosDetalhesPetDto> listarPetsDisponiveisDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrito(idOuNome);
        return petRepository.findByAbrigo(abrigo)
                .stream()
                .map(DadosDetalhesPetDto::new)
                .toList();
    }

    public Abrigo carregarAbrito(String idOuNome) {
        Optional<Abrigo> abrigoOp;
        try {
            Long id = Long.parseLong(idOuNome);
            abrigoOp = abrigoRepository.findById(id);
        }catch (NumberFormatException exception){
            abrigoOp = abrigoRepository.findByNome(idOuNome);
        }
        return abrigoOp.orElseThrow(()-> new ValidacaoException("Abrigo não encontrado"));
    }

}
