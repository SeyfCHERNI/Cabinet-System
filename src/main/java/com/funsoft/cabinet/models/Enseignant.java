package com.funsoft.cabinet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@DiscriminatorValue("Enseignant")
public class Enseignant extends Personne {
    private String departement;
}
