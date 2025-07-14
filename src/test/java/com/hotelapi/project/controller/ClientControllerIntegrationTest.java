package com.hotelapi.project.controller;

import com.hotelapi.project.model.User;
import com.hotelapi.project.model.UserRole;
import com.hotelapi.project.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelapi.project.dto.request.ClientDTOrequest;
import com.hotelapi.project.model.Client;
import com.hotelapi.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import org.springframework.http.HttpHeaders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        clientRepository.deleteAll();
        userRepository.deleteAll();

        User user = new User("laura", "12345", UserRole.ADMIN);
        userRepository.save(user);

        Client client = new Client();
        client.setName("João");
        client.setLastName("Silva");
        client.setEmail("joao@email.com");
        client.setPhone("98888-9999");
        client.setAddress("Rua A");
        client.setCpf("862.629.040-34");
        client.setRoomNumber("101");
        client.setBirthDate(LocalDate.of(1990, 1, 1));

        clientRepository.save(client);
    }


    @Test
    void testCreateClient_success() throws Exception {
        ClientDTOrequest clientDTO = new ClientDTOrequest();
        clientDTO.setName("João");
        clientDTO.setLastName("Silva");
        clientDTO.setEmail("joao@email.com");
        clientDTO.setPhone("98888-9999");
        clientDTO.setAddress("Rua A");
        clientDTO.setCpf("862.629.040-34");
        clientDTO.setRoomNumber("101");
        clientDTO.setBirthDate(LocalDate.of(1990, 1, 1));

        mockMvc.perform(post("/client")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImxhdXJhIiwiZXhwIjoxNzUyMDg0MzQxfQ.8O5DsbcN1gZ_A4T03bth9676WH-bflvVa18phavMKG0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("João")))
                .andExpect(jsonPath("$.email", is("joao@email.com")))
                .andExpect(jsonPath("$.roomNumber", is("101")))
                .andExpect(jsonPath("$.birthDate", is("1990-01-01")));
    }

    @Test
    void testGetClientByEmail() throws Exception {
        mockMvc.perform(get("/client/email")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImxhdXJhIiwiZXhwIjoxNzUyMDg0MzQxfQ.8O5DsbcN1gZ_A4T03bth9676WH-bflvVa18phavMKG0")
                        .param("email", "joao@email.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("João")))
                .andExpect(jsonPath("$.roomNumber", is("101")));

    }

    @Test
    void testGetClientByRoomNumber() throws Exception {
        mockMvc.perform(get("/client/roomNumber")
                .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImxhdXJhIiwiZXhwIjoxNzUyMDg0MzQxfQ.8O5DsbcN1gZ_A4T03bth9676WH-bflvVa18phavMKG0")
                .param("roomNumber", "101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("João")))
                .andExpect(jsonPath("$.roomNumber", is("101")));
    }

    @Test
    void testGetClientById() throws Exception {
        mockMvc.perform(get("/client/{id}", 1L)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImxhdXJhIiwiZXhwIjoxNzUyMDg0MzQxfQ.8O5DsbcN1gZ_A4T03bth9676WH-bflvVa18phavMKG0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("João")))
                .andExpect(jsonPath("$.roomNumber", is("101")));
    }

    @Test
    void testGetClientByCpf() throws Exception {
        mockMvc.perform(get("/client/cpf")
                .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImxhdXJhIiwiZXhwIjoxNzUyMDg0MzQxfQ.8O5DsbcN1gZ_A4T03bth9676WH-bflvVa18phavMKG0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("João")))
                .andExpect(jsonPath("$.cpf", is("862.629.040-34")))
                .andExpect(jsonPath("$.roomNumber", is("101")));
    }
}