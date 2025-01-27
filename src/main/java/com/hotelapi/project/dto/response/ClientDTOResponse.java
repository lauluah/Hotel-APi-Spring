package com.hotelapi.project.dto.response;

import com.hotelapi.project.util.Util;

import java.time.LocalDate;

public class ClientDTOResponse {
    private String name;
    private LocalDate birthDate;
    private String email;
    private String roomNumber;

    public ClientDTOResponse(String name, LocalDate birthDate, String email, String roomNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.roomNumber = Util.createRoomNumber();
    }

    public ClientDTOResponse() {
        this.roomNumber = Util.createRoomNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
