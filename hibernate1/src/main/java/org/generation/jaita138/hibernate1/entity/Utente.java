package org.generation.jaita138.hibernate1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String nome;

    @Column(length = 64, nullable = false)
    private String cognome;

    @Column(length = 128, nullable = false, unique = true)
    private String username;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer credito; 

    public Utente() {}

    public Utente(String nome, String cognome, String username, String password, Integer credito) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.credito = credito;
    }

    // Getter e Setter
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", credito=" + credito +
                '}';
    }
}
