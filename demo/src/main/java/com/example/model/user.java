package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity 
public class user {
    public user(Long id, String nome, String email, String serie, String cpf, String imagemfacial) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.serie = serie;
        this.cpf = cpf;
        this.imagemfacial = imagemfacial;
    }
    @Id
    private Long id;
    private String nome;
    private String email;
    private String serie;
    private String cpf;
    @Lob
    private String imagemfacial;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getImagemfacial() {
        return imagemfacial;
    }
    public void setImagemfacial(String imagemfacial) {
        this.imagemfacial = imagemfacial;
    }
}
