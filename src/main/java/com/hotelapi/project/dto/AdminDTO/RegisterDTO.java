package com.hotelapi.project.dto.AdminDTO;

import com.hotelapi.project.model.AdminRoles;

public record RegisterDTO(String login, String password, AdminRoles role) {
}
