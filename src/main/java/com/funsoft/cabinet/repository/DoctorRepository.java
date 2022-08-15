package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    // select * from doctors where firstname = ...
    public List<Doctor> findByFirstname(String firstname);
    public List<Doctor> findByFirstnameOrLastname(String firstname,String lastname);
    // select * from doctors where speciality = ...
    public List<Doctor> findBySpeciality(String speciality);

    @Query(value = "select d from Doctor d where d.speciality = :spec and "
    +"(d.firstname like :pseudo or d.lastname like :pseudo)")
    public List<Doctor> search(@Param("spec") String spec, @Param("pseudo") String pseudo);




}
