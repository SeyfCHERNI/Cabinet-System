package com.funsoft.cabinet.service;

import com.funsoft.cabinet.models.Doctor;
import com.funsoft.cabinet.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void saveOrupdate(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor get(long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
            doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> searchBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }

    @Override
    public List<Doctor> advancedSearch(String speciality, String pseudo) {
        return doctorRepository.search(speciality, pseudo+"%");
    }
}
