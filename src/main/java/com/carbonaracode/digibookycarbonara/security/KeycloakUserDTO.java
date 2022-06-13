package com.carbonaracode.digibookycarbonara.security;


public record KeycloakUserDTO(String userName, String password, Role role) {
}

