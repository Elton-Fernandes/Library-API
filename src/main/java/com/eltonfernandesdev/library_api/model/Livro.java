package com.eltonfernandesdev.library_api.model;

import jakarta.persistence.*;

@Table
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private long idLivro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "numero_paginas")
    private int numeroPaginas;

    @Column(name = "genero")
    private String genero;

    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
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

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", genero='" + genero + '\'' +
                '}';
    }
}
