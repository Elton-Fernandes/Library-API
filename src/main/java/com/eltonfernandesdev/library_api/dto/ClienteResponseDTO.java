package com.eltonfernandesdev.library_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

@Component
@Schema(name = "Cliente Response")
public class ClienteResponseDTO {

    private Long idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private boolean banned;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

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
