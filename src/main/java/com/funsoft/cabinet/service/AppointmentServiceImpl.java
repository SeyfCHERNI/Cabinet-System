package com.funsoft.cabinet.service;

import com.funsoft.cabinet.models.Appointment;
import com.funsoft.cabinet.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public void saveOrupdate(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment get(long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
