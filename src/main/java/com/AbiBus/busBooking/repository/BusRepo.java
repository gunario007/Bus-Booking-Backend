package com.AbiBus.busBooking.repository;

import com.AbiBus.busBooking.Models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus,Long> {

     List<Bus> findByBusType(String BusClass);
}
