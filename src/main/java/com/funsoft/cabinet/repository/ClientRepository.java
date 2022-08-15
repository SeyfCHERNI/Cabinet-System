package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
