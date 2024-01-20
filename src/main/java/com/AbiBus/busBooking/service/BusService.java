package com.AbiBus.busBooking.service;

import com.AbiBus.busBooking.Models.Bus;
import com.AbiBus.busBooking.dto.BusDto;
import com.AbiBus.busBooking.dto.UserLoginDto;
import com.AbiBus.busBooking.exception.BusException;
import com.AbiBus.busBooking.exception.ResourceNotFoundException;

import java.util.List;

public interface BusService {

    BusDto addBus(BusDto busDto);
    BusDto updateBus(BusDto busDto);
    void deleteBus(Long busId);
    BusDto viewBusById(Long busId);

    List<BusDto> viewAllBuses();





}
