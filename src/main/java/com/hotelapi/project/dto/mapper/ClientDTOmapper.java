package com.hotelapi.project.dto.mapper;

import com.hotelapi.project.dto.request.ClientDTOrequest;
import com.hotelapi.project.dto.response.ClientDTOResponse;
import com.hotelapi.project.model.Client;

public class ClientDTOmapper {

    public static Client toEntity(ClientDTOrequest clientDTOrequest) {
        Client client = new Client();
        client.setFirstName(clientDTOrequest.getFirstName());
        client.setLastName(clientDTOrequest.getLastName());
        client.setEmail(clientDTOrequest.getEmail());
        client.setPhone(clientDTOrequest.getPhone());
        client.setAddress(clientDTOrequest.getAddress());
        client.setCpf(clientDTOrequest.getCpf());
        client.setBirthDate(clientDTOrequest.getBirthDate());
        return client;
    }

    public static ClientDTOResponse toResponse(Client client) {
        ClientDTOResponse clientResponse = new ClientDTOResponse();
        clientResponse.setBirthDate(client.getBirthDate());
        clientResponse.setFirstName(client.getFirstName());
        clientResponse.setEmail(client.getEmail());
       // clientResponse.setRoomNumber(client.getRoomNumber());
        return clientResponse;
    }
}
