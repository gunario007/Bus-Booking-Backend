package com.AbiBus.busBooking.controller;

import com.AbiBus.busBooking.Models.Booking;
import com.AbiBus.busBooking.dto.BookingDto;
import com.AbiBus.busBooking.exception.BookingException;
import com.AbiBus.busBooking.exception.BusException;
import com.AbiBus.busBooking.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD API's for Booking Resource"

)

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class BookingController {

    private BookingService bookingService;


    @Operation(
            summary = "Create Booking Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )


    @PostMapping("/booking/bookingId")
    public ResponseEntity<BookingDto> addBooking(@Valid @RequestBody BookingDto bookingDto)  {
        BookingDto savedBooking =bookingService.addBooking(bookingDto);
        return new ResponseEntity<BookingDto>(savedBooking, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Delete an Booking Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )


    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable("bookingId") Long bookingId ) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>("booking deleted successfully", HttpStatus.OK);
    }

    @Operation(
            summary = "Get Booking Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )


    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<BookingDto> viewBooking(@PathVariable("bookingId") Long bookingId) throws BookingException{
        BookingDto foundBooking = bookingService.viewBooking(bookingId);
        return new ResponseEntity<BookingDto>(foundBooking,HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Booking Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )


    @GetMapping("/booking")
    public ResponseEntity<List<BookingDto>> viewAllBooking() throws BookingException{
        List<BookingDto> BookingList = bookingService.viewAllBooking();
        return new ResponseEntity<List<BookingDto>>(BookingList,HttpStatus.OK);
    }









}
