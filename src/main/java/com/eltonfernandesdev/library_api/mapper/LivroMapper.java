package com.eltonfernandesdev.library_api.mapper;

import com.eltonfernandesdev.library_api.dto.LivroRequestDTO;
import com.eltonfernandesdev.library_api.dto.LivroResponseDTO;
import com.eltonfernandesdev.library_api.model.Autor;
import com.eltonfernandesdev.library_api.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro toEntity(LivroRequestDTO dto) {

        Livro livro = new Livro();

        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setNumeroPaginas(dto.getNumeroPaginas());
        livro.setGenero(dto.getGenero());

        return livro;
    }

    public LivroResponseDTO toResponseDTO(Livro livro) {

        LivroResponseDTO dto = new LivroResponseDTO();

        dto.setIdLivro(livro.getIdLivro());
        dto.setGenero(livro.getGenero());
        dto.setIsbn(livro.getIsbn());
        dto.setNumeroPaginas(livro.getNumeroPaginas());
        dto.setTitulo(livro.getTitulo());
        dto.setIdEditora(livro.getEditora().getIdEditora());
        dto.setAutores(livro.getAutores()
                .stream()
                .map(Autor::getIdAutor)
                .toList());

        return dto;
    }
}