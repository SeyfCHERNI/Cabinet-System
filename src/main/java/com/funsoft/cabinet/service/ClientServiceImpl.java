package com.funsoft.cabinet.service;

import com.funsoft.cabinet.models.Client;
import com.funsoft.cabinet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{


    @Autowired
    ClientRepository clientRepository;

    @Override
    public void saveOrupdate(Client client) {
        clientRepository.save(client);
        // envoyer un email
    }

    @Override
    public Client getClient(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
