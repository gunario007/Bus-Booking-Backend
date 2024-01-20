package com.AbiBus.busBooking.service;

import com.AbiBus.busBooking.dto.BookingDto;
import com.AbiBus.busBooking.dto.UserLoginDto;
import com.AbiBus.busBooking.exception.BookingException;

import java.util.List;

public interface BookingService {


    BookingDto addBooking(BookingDto bookingDto) ;

    void deleteBooking(Long bookingId);

    BookingDto viewBooking(Long bookingId) throws BookingException;



    List<BookingDto> viewAllBooking() throws BookingException;


}
