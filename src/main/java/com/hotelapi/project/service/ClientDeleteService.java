package com.hotelapi.project.service;

import com.hotelapi.project.exceptions.ClientNotFoundException;
import com.hotelapi.project.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientDeleteService {
    private ClientRepository clientRepository;

    public ClientDeleteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<String> deleteClientService(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok("Client deleted successfully");
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }
}
