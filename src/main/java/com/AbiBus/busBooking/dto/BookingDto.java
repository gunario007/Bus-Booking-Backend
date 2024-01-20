package com.AbiBus.busBooking.dto;

import com.AbiBus.busBooking.Models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BookingDto {
    private Long bookingId;

    private LocalDate bookingDate;


    private String source;



    private String destination;

    private String bookingStatus;


    private Integer noOfSeatsToBook;


    private LocalDate journeyDate;

    private Double price;

    private BusDto busDto;

    private User user;


}
