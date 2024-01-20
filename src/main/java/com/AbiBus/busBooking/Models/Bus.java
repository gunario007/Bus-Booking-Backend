package com.AbiBus.busBooking.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buses")

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long busId;



    @NotNull(message = "Bus name cannot be null!")
    private String busName;


    @NotNull(message = "Start point cannot be null!")
    @NotBlank(message = "Start point cannot be blank!")
    private String routeFrom;

    @NotNull(message = "Start point cannot be null!")
    @NotBlank(message = "Start point cannot be blank!")
    private String routeTo;



    @NotNull(message = "Departure time cannot be null!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String departure;

    @NotNull(message = "Arrival time cannot be null!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private String arrival;


    private String busType;


    @NotNull(message = "Total Seats cannot be null!")
    private Integer seats;



    @NotNull(message = "Price cannot be null!")
    private Double price;

    @NotNull(message = "Bus journey date cannot be null!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate journeyDate;







}
