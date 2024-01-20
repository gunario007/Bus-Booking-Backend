package com.AbiBus.busBooking.repository;

import com.AbiBus.busBooking.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
