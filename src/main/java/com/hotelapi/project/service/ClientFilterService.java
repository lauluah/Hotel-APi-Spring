package com.hotelapi.project.service;

import com.hotelapi.project.exceptions.ClientNotFoundException;
import com.hotelapi.project.model.Client;
import com.hotelapi.project.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientFilterService {

    private final ClientRepository clientRepository;

    public ClientFilterService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClientByName(String clientName) {
        List<Client> clients = clientRepository.findByName(clientName);
        if (clients.isEmpty()) {
            throw new ClientNotFoundException(String.format("Não foi possível encontrar clientes com o nome: %s", clientName));
        }
        return clients;
    }

    public Client getClientBYEmail(String email) {
        Optional<Client> client = clientRepository.findByEmail(email);
        if (client.isEmpty()) {
            throw new ClientNotFoundException(String.format("Não foi possível encontrar cliente com o email: %s", email));
        }
        return client.get();
    }

    public Client getClientByRoomNumber(String roomNumber) {
        Optional<Client> client = clientRepository.findByRoomNumber(roomNumber);
        if (client.isEmpty()) {
            throw new ClientNotFoundException(String.format("Não foi possível encontrar cliente no quarto: %s", roomNumber));
        }
        return client.get();
    }

    public Client getClientById(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isEmpty()) {
            throw new ClientNotFoundException(String.format("Não foi possível encontrar cliente com o id: %s", clientId));
        }
        return client.get();
    }
}
