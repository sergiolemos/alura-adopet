package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.TipoPet;

public record DadosDetalhesPetDto(
        Long id,
        TipoPet tipo,
        String nome,
        String raca,
        Integer idade,
        String cor
) {
    public DadosDetalhesPetDto(Pet pet){
        this(pet.getId(), pet.getTipo(),pet.getNome(), pet.getRaca(),pet.getIdade(),pet.getCor());
    }
}
