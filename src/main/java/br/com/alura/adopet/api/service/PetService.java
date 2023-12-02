package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.DadosDetalhesPet;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<DadosDetalhesPet> listarPetsDisponiveis(){
        List<Pet> pets = petRepository.findAllByAndAdotadoFalse();
        return pets.stream().map(DadosDetalhesPet::new).toList();
    }
}
