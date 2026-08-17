package com.eltonfernandesdev.library_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AutorRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;
    @NotBlank(message = "A nacionalidade é obrigatória")
    private String nacionalidade;

    private LocalDate dataNascimento;

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
