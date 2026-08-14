package com.eltonfernandesdev.library_api.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroResponseDTO {

    private Long idLivro;
    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private String genero;
    private Long idEditora;
    private List<Long> autores;

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

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
