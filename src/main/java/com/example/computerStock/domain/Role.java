package com.example.computerStock.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    ZAVSKLAD;

    @Override
    public String getAuthority() {
        return name();
    }
}
