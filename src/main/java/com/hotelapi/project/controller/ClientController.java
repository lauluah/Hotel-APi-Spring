package com.hotelapi.project.controller;

import com.hotelapi.project.dto.request.ClientDTOrequest;
import com.hotelapi.project.dto.response.ClientDTOResponse;
import com.hotelapi.project.service.ClientCreatorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Clients")
public class ClientController {

    ClientCreatorService clientCreatorService;

    public ClientController(ClientCreatorService clientCreatorService) {
        this.clientCreatorService = clientCreatorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTOResponse createClient(@Valid @RequestBody ClientDTOrequest clientDTOrequest) {
        return clientCreatorService.createClientService(clientDTOrequest);
    }

}
