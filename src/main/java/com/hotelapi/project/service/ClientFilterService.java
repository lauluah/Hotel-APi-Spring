package com.hotelapi.project.service;

import com.hotelapi.project.exceptions.ClientNotFoundException;
import com.hotelapi.project.model.Client;
import com.hotelapi.project.repository.ClientRepository;

import java.util.List;

public class ClientFilterService {

    private final ClientRepository clientRepository;


    public ClientFilterService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClientByName(String clientName) {
        List<Client> clients = clientRepository.findByName(clientName);
        if (clients.isEmpty()) {
            throw new ClientNotFoundException(String.format("Não foi possível encontrar clientes com o nome %s", clientName));
        }
        return clients;
    }
}
