package com.hotelapi.project.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class ClientDTOrequest {

    @NotBlank(message = "The name is required and cannot be blank.")
    @Size(min = 3, max = 50, message = "The name must be between 3 and 50 characters.")
    private String name;

    @Column(name = "lastName", nullable = false)
    @NotBlank(message = "The last name is required and cannot be blank.")
    private String lastName;

    @Past(message = "The birth date must be in the past.")
    private LocalDate birthDate;

    @NotBlank(message = "The email is required and cannot be blank.")
    @Pattern(regexp = "^[A-Za-z0-9._%+]+@[A-Za-z0-9]+(\\.[A-Za-z]{2,})+$", message = "The email format is invalid. Please check if the email is correct.")
    private String email;

    @NotBlank(message = "The phone number is required and cannot be blank.")
    private String phone;

    @NotBlank(message = "The address is required and cannot be blank.")
    private String address;

    @NotBlank(message = "The CPF is required and cannot be blank.")
    @CPF(message = "The CPF format is invalid. Please enter a valid CPF.")
    private String cpf;

    public ClientDTOrequest(String name, String lastName, LocalDate birthDate, String email, String phone, String address, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
