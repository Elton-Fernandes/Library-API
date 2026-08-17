package com.eltonfernandesdev.library_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class EditoraRequestDTO {

    @NotBlank(message = "O email é obrigatório")
    @Email
    private String email;
    @NotBlank(message = "O número de telefone é obrigatório")
    @Size(min = 9, max = 11)
    private String telefone;
    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;
    @NotBlank(message = "O nome da empresa é obrigatório")
    @Size(min = 1)
    private String nome;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
