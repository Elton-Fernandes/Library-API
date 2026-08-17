package com.eltonfernandesdev.library_api.dto;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 2)
    private String titulo;
    @NotBlank(message = "O ISBN é obrigatório")
    private String isbn;
    @NotNull
    @Positive
    private int numeroPaginas;
    @NotBlank(message = "O gênero do livro é obrigatório")
    private String genero;
    @NotNull(message = "O id da editora é obrigatório")
    @Positive
    private Long idEditora;
    @NotEmpty(message = "O livro deve possuir pelo menos um autor")
    private List<@Positive(message = "O id do autor precisa ser positivo") Long> autores;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }

    public List<Long> getAutores() {
        return autores;
    }

    public void setAutores(List<Long> autores) {
        this.autores = autores;
    }
}
