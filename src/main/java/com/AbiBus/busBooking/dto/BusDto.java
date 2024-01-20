package com.AbiBus.busBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {

    private Long busId;
    private String busName;
    private String routeFrom;
    private String routeTo;


    private String departure;

    private String arrival;
    private String busType;
    private Integer seats;
    private Double price;
    private LocalDate journeyDate;


}
