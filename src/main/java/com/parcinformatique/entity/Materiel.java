package com.parcinformatique.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref;
    private String type;
    private String marque;

    @Enumerated(EnumType.STRING)
    private EtatMateriel etat;

    private LocalDate dateAchat;

    public Materiel() {}

    public Materiel(Long id, String ref, String type, String marque, EtatMateriel etat, LocalDate dateAchat) {
        this.id = id;
        this.ref = ref;
        this.type = type;
        this.marque = marque;
        this.etat = etat;
        this.dateAchat = dateAchat;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public EtatMateriel getEtat() { return etat; }
    public void setEtat(EtatMateriel etat) { this.etat = etat; }
    public LocalDate getDateAchat() { return dateAchat; }
    public void setDateAchat(LocalDate dateAchat) { this.dateAchat = dateAchat; }
}
