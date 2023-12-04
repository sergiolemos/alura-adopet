package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.DadosCadastroPetDto;
import br.com.alura.adopet.api.dto.DadosDetalhesPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<DadosDetalhesPetDto> listarPetsDisponiveis(){
        return petRepository.findAllByAdotadoFalse()
                .stream()
                .map(DadosDetalhesPetDto::new)
                .toList();
    }

    public void cadastar(DadosCadastroPetDto dto, Abrigo abrigo){
        Pet pet = new Pet(dto, abrigo);
        petRepository.save(pet);
    }


}
