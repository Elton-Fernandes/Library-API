package com.eltonfernandesdev.library_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Schema(name = "Autor Response")
public class AutorResponseDTO {

    private Long idAutor;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
