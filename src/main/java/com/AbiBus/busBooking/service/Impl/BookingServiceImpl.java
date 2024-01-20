package com.AbiBus.busBooking.service.Impl;

import com.AbiBus.busBooking.Models.Booking;
import com.AbiBus.busBooking.Models.Bus;
import com.AbiBus.busBooking.Models.User;
import com.AbiBus.busBooking.dto.BookingDto;
import com.AbiBus.busBooking.dto.BusDto;
import com.AbiBus.busBooking.dto.UserLoginDto;
import com.AbiBus.busBooking.exception.BookingException;
import com.AbiBus.busBooking.exception.BusException;
import com.AbiBus.busBooking.exception.ResourceNotFoundException;
import com.AbiBus.busBooking.repository.BookingRepo;
import com.AbiBus.busBooking.repository.BusRepo;
import com.AbiBus.busBooking.repository.UserRepo;
import com.AbiBus.busBooking.service.BookingService;
import com.AbiBus.busBooking.service.BusService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {



    private BookingRepo bookingRepo;
    private ModelMapper modelMapper;




    @Override
    public BookingDto addBooking(BookingDto bookingDto)  {

        Booking booking=modelMapper.map(bookingDto, Booking.class);
        Booking createMedication=bookingRepo.save(booking);
        BookingDto createBookingnDto=modelMapper.map(booking, BookingDto.class);
        return createBookingnDto;


    }

    @Override
    public void deleteBooking(Long bookingId) {

        Booking existingBooking = bookingRepo.findById(bookingId).
                orElseThrow(()->new ResourceNotFoundException("booking","id",bookingId));

        bookingRepo.deleteById(existingBooking.getBookingId());

    }

    @Override
    public BookingDto viewBooking(Long id) throws BookingException {
        Optional<Booking> booking = bookingRepo.findById(id);
        Booking foundBooking = booking.
                orElseThrow(()-> new BookingException("No reservation found!"));


        return modelMapper.map(foundBooking,BookingDto.class);
    }


    @Override
    public List<BookingDto> viewAllBooking() throws BookingException {



        List<Booking> bookingList = bookingRepo.findAll();
        if(bookingList.isEmpty()) throw new BookingException("No reservations found!");

        List<BookingDto> bookingDtos= bookingList.stream().map(booking -> modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
        return bookingDtos;

    }
}
