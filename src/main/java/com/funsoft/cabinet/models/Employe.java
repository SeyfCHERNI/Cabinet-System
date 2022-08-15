package com.funsoft.cabinet.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "projets_employes",
            joinColumns = {
                    @JoinColumn(name = "employe_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "projet_ID",
                    nullable = false, updatable = false) })
    private List<Projet> projets;
}
