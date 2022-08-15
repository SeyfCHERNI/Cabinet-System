package com.funsoft.cabinet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //compteur par table
    private long id;
    @NotEmpty(message = "firstname is mondatory !!!!")
    @Size(min = 3,max = 10, message = "longuer doit être entre 3 et 10 caractéres")
    @Pattern(regexp = "[a-zA-Z]+",message = "firstname doit être composé uniquement par des alphabets")
    @Column(name = "firstname_client",length = 30,nullable = false)
    private String firstname;
    @NotEmpty(message = "lastname is mondatory !!!!")
    @Size(min = 3,max = 10, message = "longuer doit être entre 3 et 10 caractéres")
    @Pattern(regexp = "[a-zA-Z]+",message = "lastname doit être composé uniquement par des alphabets")
    private String lastname;
    @NotEmpty(message = "phone is mondatory !!!!")
    @Size(min = 8,max = 13, message = "longuer doit être entre 3 et 13 caractéres")
    @Pattern(regexp = "[0-9]+",message = "phone doit être composé uniquement par des chiffres")
    @Column(nullable = false,unique = true)
    private String phone;
    @Email(message = "l'adresse email n'est correcte")
    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Appointment> appointmentList;

}
