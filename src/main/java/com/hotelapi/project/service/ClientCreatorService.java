package com.hotelapi.project.service;

import com.hotelapi.project.dto.mapper.ClientDTOmapper;
import com.hotelapi.project.dto.request.ClientDTOrequest;
import com.hotelapi.project.dto.response.ClientDTOResponse;
import com.hotelapi.project.model.Client;
import com.hotelapi.project.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientCreatorService {
    ClientRepository clientRepository;

    public ClientCreatorService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTOResponse createClientService(ClientDTOrequest clientDTO) {
        Client clientEntity = ClientDTOmapper.toEntity(clientDTO);
        Client createdClient = clientRepository.save(clientEntity);
        return ClientDTOmapper.toResponse(createdClient);
    }
}
