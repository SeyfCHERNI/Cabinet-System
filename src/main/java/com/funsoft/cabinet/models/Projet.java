package com.funsoft.cabinet.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameProjet;

    @ManyToMany
    @JoinTable(name = "projets_employes",
            joinColumns = {
            @JoinColumn(name = "projet_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "employe_ID",
                    nullable = false, updatable = false) })
    private List<Employe> employes;
}
