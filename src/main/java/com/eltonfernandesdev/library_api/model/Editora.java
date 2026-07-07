package com.eltonfernandesdev.library_api.model;

import jakarta.persistence.*;

@Table
@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editora")
    private long idEditora;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome")
    private String nome;

    public long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(long idEditora) {
        this.idEditora = idEditora;
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

    @Override
    public String toString() {
        return "Editora{" +
                "idEditora=" + idEditora +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
