package com.hotelapi.project.useCases;

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

        User user = new User("laura", "12345", UserRole.ADMIN);

        userRepository.save(user);
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
                        .param("email", "joao@email.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("João")))
                .andExpect(jsonPath("$.roomNumber", is("101")));

    }

}