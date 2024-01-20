package com.AbiBus.busBooking.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisteredDto {

    private String name;

    private String email;

    private String password;

    private String role;


}
