package com.example.demo.service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<Client> update(Long id, Client clientDetails) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setNom(clientDetails.getNom());
            client.setEmail(clientDetails.getEmail());
            client.setAdresse(clientDetails.getAdresse());
            client.setTelephone(clientDetails.getTelephone());



            Client savedClient = clientRepository.save(client);
            return new ResponseEntity<>(savedClient, HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>(clientDetails, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> delete(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientRepository.delete(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Client> create(Client client) {
        Client savedClient = clientRepository.save(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    public ResponseEntity<Client> getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    public List<Client> findAll() {
        System.out.println("meeeeeeeeed");
        return clientRepository.findAll();
    }
}
