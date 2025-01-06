package com.hotelapi.project.repository;

import com.hotelapi.project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNomeContaining(String nome);

    Optional<Client> findByCpf(String cpf);

    Optional<Client> findByEmail(String email);

    Optional<Client> findByPhone(String phone);

    Optional<Client> findByRoomNumber(String roomNumber);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}

