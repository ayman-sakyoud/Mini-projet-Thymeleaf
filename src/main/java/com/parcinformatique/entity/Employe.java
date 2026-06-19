package com.parcinformatique.entity;

import jakarta.persistence.*;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String service;
    private String email;

    public Employe() {}

    public Employe(Long id, String nom, String service, String email) {
        this.id = id;
        this.nom = nom;
        this.service = service;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
