package com.hotelapi.project.dto.response;

import com.hotelapi.project.util.Util;

import java.time.LocalDate;

public class ClientDTOResponse {
    private String firstName;
    private LocalDate birthDate;
    private String email;
    private String roomNumber;

    public ClientDTOResponse(String firstName, LocalDate birthDate, String email) {
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.email = email;
        this.roomNumber = Util.createRoomNumber();
    }

    public ClientDTOResponse() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getRoomNumber(String roomNumber) {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
