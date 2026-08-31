package com.eltonfernandesdev.library_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

@Component
@Schema(name = "Editora Response")
public class EditoraResponseDTO {

    private Long idEditora;
    private String email;
    private String telefone;
    private String cnpj;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }
}
