package com.hotelapi.project.dto.UserDTO;

import com.hotelapi.project.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
