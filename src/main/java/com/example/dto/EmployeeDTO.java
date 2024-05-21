package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {

    private long id;
    private String name;
    private String location;
    private String email;
    private String attributes;
}