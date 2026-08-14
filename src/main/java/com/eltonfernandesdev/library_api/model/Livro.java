package com.eltonfernandesdev.library_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long idLivro;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "isbn", length = 13,unique = true, nullable = false)
    private String isbn;

    @Column(name = "numero_paginas", nullable = false)
    private int numeroPaginas;

    @Column(name = "genero", nullable = false)
    private String genero;

    @ManyToMany
    @JoinTable(
            name = "Escreve",
            joinColumns = @JoinColumn(name = "id_livro"),
            inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora editora;

    @OneToMany(mappedBy = "livro")
    @JsonIgnore
    private List<Emprestimo> emprestimos = new ArrayList<>();


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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", genero='" + genero + '\'' +
                ", autores=" + autores.size() + "autor(es)" +
                ", editora=" + (editora != null ? editora.getNome() : null) +
                ", emprestimos=" + emprestimos.size() + "empréstimo(s)" +
                '}';
    }
}
