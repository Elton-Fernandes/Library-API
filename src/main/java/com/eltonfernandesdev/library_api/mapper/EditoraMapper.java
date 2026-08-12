package com.eltonfernandesdev.library_api.mapper;

import com.eltonfernandesdev.library_api.dto.EditoraRequestDTO;
import com.eltonfernandesdev.library_api.dto.EditoraResponseDTO;
import com.eltonfernandesdev.library_api.model.Editora;
import org.springframework.stereotype.Component;

@Component
public class EditoraMapper {

    public Editora toEntity(EditoraRequestDTO dto) {

        Editora editora = new Editora();

        editora.setCnpj(dto.getCnpj());
        editora.setEmail(dto.getEmail());
        editora.setNome(dto.getNome());
        editora.setTelefone(dto.getTelefone());

        return editora;
    }

    public EditoraResponseDTO toResponseDTO(Editora editora) {

        EditoraResponseDTO dto = new EditoraResponseDTO();

        dto.setIdEditora(editora.getIdEditora());
        dto.setCnpj(editora.getCnpj());
        dto.setEmail(editora.getEmail());
        dto.setNome(editora.getNome());
        dto.setTelefone(editora.getTelefone());

        return dto;
    }
}
