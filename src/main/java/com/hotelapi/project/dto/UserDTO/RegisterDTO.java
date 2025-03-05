package com.hotelapi.project.dto.UserDTO;

import com.hotelapi.project.model.UserRoles;

public record RegisterDTO(String login, String password, UserRoles role) {
}
