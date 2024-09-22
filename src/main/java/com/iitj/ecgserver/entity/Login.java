package com.iitj.ecgserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Login {
    @Id
    private String userId;
    private String password;
}
