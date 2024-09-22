package com.iitj.ecgserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    private String id;
    private String name;
    private String gender;
    private String age;
}
