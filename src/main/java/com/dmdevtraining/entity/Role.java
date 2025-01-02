package com.dmdevtraining.entity;

import lombok.Getter;

@Getter
public enum Role {

    USER("User"),
    ADMIN("Admin");

    final String name;

    Role(String name) {
        this.name = name;
    }

}
