package com.AbiBus.busBooking.service.Impl;

import com.AbiBus.busBooking.Models.Bus;

import com.AbiBus.busBooking.dto.BusDto;

import com.AbiBus.busBooking.exception.ResourceNotFoundException;
import com.AbiBus.busBooking.repository.BusRepo;
import com.AbiBus.busBooking.service.BusService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class BusServiceImpl implements BusService {

    private BusRepo busRepo;
    private ModelMapper modelMapper;



    @Override
    public BusDto addBus(BusDto busDto) {
        Bus bus=modelMapper.map(busDto,Bus.class);
        Bus addBus=busRepo.save(bus);
        BusDto addBusDto=modelMapper.map(bus,BusDto.class);


        return addBusDto;
    }

    @Override
    public BusDto updateBus(BusDto busDto)  {
        Bus bus=modelMapper.map(busDto,Bus.class);


        Bus existingBus= busRepo.findById(bus.getBusId()).
                orElseThrow(()->new ResourceNotFoundException("bus","id",bus.getBusId()));
        existingBus.setBusName(bus.getBusName());
        existingBus.setRouteFrom(bus.getRouteFrom());
        existingBus.setRouteTo(bus.getRouteTo());
        existingBus.setArrival(bus.getArrival());
        existingBus.setDeparture(bus.getDeparture());
        existingBus.setJourneyDate(bus.getJourneyDate());

        Bus updatedBus=busRepo.save(existingBus);

        BusDto updatedBusDto=modelMapper.map(updatedBus, BusDto.class);
        return updatedBusDto;




    }

    @Override
    public void deleteBus(Long busId)  {
        Bus existingBus = busRepo.findById(busId).
                orElseThrow(()->new ResourceNotFoundException("bus","id",busId));
        busRepo.deleteById(existingBus.getBusId());
    }

    @Override
    public BusDto viewBusById(Long busId) {

        Bus bus = busRepo.findById(busId)
                .orElseThrow(()->new ResourceNotFoundException("bus","id",busId));


        return modelMapper.map(bus, BusDto.class);
    }



    @Override
    public List<BusDto> viewAllBuses() {
        List<Bus> buses=busRepo.findAll();
        List<BusDto> busDtos= buses.stream().map(bus -> modelMapper.map(bus, BusDto.class)).collect(Collectors.toList());

        return busDtos;
    }
}
