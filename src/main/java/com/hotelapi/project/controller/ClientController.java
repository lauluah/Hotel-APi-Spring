package com.hotelapi.project.controller;

import com.hotelapi.project.dto.request.ClientDTOrequest;
import com.hotelapi.project.dto.response.ClientDTOResponse;
import com.hotelapi.project.model.Client;
import com.hotelapi.project.service.ClientCreatorService;
import com.hotelapi.project.service.ClientDeleteService;
import com.hotelapi.project.service.ClientFilterService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientCreatorService clientCreatorService;
    ClientFilterService clientFilterService;
    ClientDeleteService clientDeleteService;

    public ClientController(ClientCreatorService clientCreatorService, ClientFilterService clientFilterService, ClientDeleteService clientDeleteService) {
        this.clientCreatorService = clientCreatorService;
        this.clientFilterService = clientFilterService;
        this.clientDeleteService = clientDeleteService;
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

    @GetMapping("/email")
    public Client getClientByEmail(@RequestParam String email) {
        return clientFilterService.getClientBYEmail(email);
    }

    @GetMapping("/roomNumber")
    public Client getClientByRoomNumber(@RequestParam String roomNumber) {
        return clientFilterService.getClientByRoomNumber(roomNumber);
    }

    @GetMapping("{id}")
    public Client getClientByRoomNumber(@PathVariable Long id) {
        return clientFilterService.getClientById(id);
    }

    @GetMapping("/cpf")
    public Client getClientByCpf(@RequestParam String cpf) {
        return clientFilterService.getClientByCpf(cpf);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        return clientDeleteService.deleteClientService(id);
    }
}
