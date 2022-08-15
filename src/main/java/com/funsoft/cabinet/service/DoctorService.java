package com.funsoft.cabinet.service;

import com.funsoft.cabinet.models.Doctor;

import java.util.List;

public interface DoctorService {
    public void saveOrupdate(Doctor doctor);
    public Doctor get(long id);
    public void delete(long id);
    public List<Doctor> getAll();
    public List<Doctor> searchBySpeciality(String speciality);
    public List<Doctor> advancedSearch(String speciality,String pseudo);
}
