package com.funsoft.cabinet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SearchDoctor {
    private String pseudo;
    private String speciality;
    private List<Doctor> doctors;
}
