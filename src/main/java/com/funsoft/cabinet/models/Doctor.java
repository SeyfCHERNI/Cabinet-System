package com.funsoft.cabinet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors") // pour changer le nom de la table dans la BD
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "firstname is mondatory !!!!")
    @Size(min = 3,max = 10, message = "longuer doit être entre 3 et 10 caractéres")
    @Pattern(regexp = "[a-zA-Z]+",message = "firstname doit être composé uniquement par des alphabets")
    private String firstname;
    @NotEmpty(message = "lastname is mondatory !!!!")
    @Size(min = 3,max = 10, message = "longuer doit être entre 3 et 10 caractéres")
    @Pattern(regexp = "[a-zA-Z]+",message = "lastname doit être composé uniquement par des alphabets")
    private String lastname;
    @Email(message = "l'adresse email n'est correcte")
    @Column(nullable = false,unique = true)
    private String address;
    @NotEmpty(message = "phone is mondatory !!!!")
    @Size(min = 8,max = 13, message = "longuer doit être entre 3 et 13 caractéres")
    @Pattern(regexp = "[0-9]+",message = "phone doit être composé uniquement par des chiffres")
    @Column(nullable = false,unique = true)
    private String phone;
    @NotEmpty(message = "speciality is mondatory !!!!")
    private String speciality;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Appointment> appointmentList;
}
