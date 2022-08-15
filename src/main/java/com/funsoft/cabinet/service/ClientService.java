package com.funsoft.cabinet.service;

import com.funsoft.cabinet.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public void saveOrupdate(Client client);
    public Client getClient(long id);
    public void delete(long id);
    public List<Client> getAll();

}
