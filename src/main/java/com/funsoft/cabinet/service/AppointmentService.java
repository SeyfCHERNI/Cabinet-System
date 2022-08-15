package com.funsoft.cabinet.service;

import com.funsoft.cabinet.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AppointmentService {

    public void saveOrupdate(Appointment appointment);
    public Appointment get(long id);
    public void delete(long id);
    public List<Appointment> getAll();
}
