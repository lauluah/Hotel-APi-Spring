package com.hotelapi.project.controller;

import com.hotelapi.project.dto.request.ClientDTOrequest;
import com.hotelapi.project.dto.response.ClientDTOResponse;
import com.hotelapi.project.model.Client;
import com.hotelapi.project.service.ClientCreatorService;
import com.hotelapi.project.service.ClientFilterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientCreatorService clientCreatorService;
    ClientFilterService clientFilterService;

    public ClientController(ClientCreatorService clientCreatorService, ClientFilterService clientFilterService) {
        this.clientCreatorService = clientCreatorService;
        this.clientFilterService = clientFilterService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTOResponse createClient(@Valid @RequestBody ClientDTOrequest clientDTOrequest) {
        return clientCreatorService.createClientService(clientDTOrequest);
    }

    @GetMapping("/name")
    public List<Client> getClientsByName(@RequestParam String name) {
          return clientFilterService.getClientByName(name);
    }
}
