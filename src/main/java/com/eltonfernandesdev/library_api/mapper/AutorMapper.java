package com.eltonfernandesdev.library_api.mapper;

import com.eltonfernandesdev.library_api.dto.AutorRequestDTO;
import com.eltonfernandesdev.library_api.dto.AutorResponseDTO;
import com.eltonfernandesdev.library_api.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public Autor toEntity(AutorRequestDTO dto) {

        Autor autor = new Autor();

        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autor.setDataNascimento(dto.getDataNascimento());

        return autor;
    }

    public AutorResponseDTO toResponseDTO(Autor autor) {

        AutorResponseDTO dto = new AutorResponseDTO();

        dto.setIdAutor(autor.getIdAutor());
        dto.setDataNascimento(autor.getDataNascimento());
        dto.setNacionalidade(autor.getNacionalidade());
        dto.setNome(autor.getNome());

        return dto;

    }
}
