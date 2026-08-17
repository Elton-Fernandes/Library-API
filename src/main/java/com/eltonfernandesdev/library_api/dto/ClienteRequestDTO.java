package com.eltonfernandesdev.library_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class ClienteRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;
    @NotBlank(message = "O cpf é obrigatório")
    private String cpf;
    @NotBlank(message = "O email é obrigatório")
    @Email
    private String email;
    @NotBlank(message = "O número de telefone é obrigatório")
    @Size(min = 9, max = 11)
    private String telefone;
    @NotNull(message = "Informação obrigatória")
    private boolean banned;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
