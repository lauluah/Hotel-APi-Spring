package com.hotelapi.project.model;

public enum AdminRoles {
    ADMIN("admin"),
    USER("user");

    private String role;

    AdminRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
