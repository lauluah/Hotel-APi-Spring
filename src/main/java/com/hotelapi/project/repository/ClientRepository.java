package com.hotelapi.project.repository;

import com.hotelapi.project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

   Optional<Client> findByEmail(String email);

   List<Client> findByName(String name);

}

