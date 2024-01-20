package com.AbiBus.busBooking.controller;

import com.AbiBus.busBooking.Models.Bus;
import com.AbiBus.busBooking.dto.BusDto;
import com.AbiBus.busBooking.exception.BusException;
import com.AbiBus.busBooking.service.BusService;
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
        name = "CRUD API's for Bus Resource"

)


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BusController {

    private BusService busService;

    @Operation(
            summary = "Create Bus Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )



    @PostMapping("/bus")
    public ResponseEntity<BusDto> addBus(@Valid @RequestBody BusDto busDto){

        BusDto createBus=busService.addBus(busDto);

        return new ResponseEntity<BusDto>(createBus, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update an Bus Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @PutMapping("/bus/{busId}")
    public ResponseEntity<BusDto> updateBus(@PathVariable("busId") Long busId,
                                            @Valid @RequestBody BusDto busDto) throws BusException {


        busDto.setBusId(busId);
        BusDto updateBus=busService.updateBus(busDto);

        return new ResponseEntity<>(updateBus,HttpStatus.OK);
    }

    @Operation(
            summary = "Delete an Bus Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )

    @DeleteMapping("/bus/{busId}")
    public ResponseEntity<String> deleteBus(@PathVariable("medicationId") Long busId){
        busService.deleteBus(busId);
        return new ResponseEntity<>("Bus details deleted successfully", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Get Bus Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @GetMapping("/bus/{busId}")
    public ResponseEntity<BusDto> viewBusById(@PathVariable("busId") Long busId) {
        BusDto busDto = busService.viewBusById(busId);
        return new ResponseEntity<>(busDto, HttpStatus.OK);

    }
    @Operation(
            summary = "Get All Bus Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )

    @GetMapping("/buses")
    public ResponseEntity<List<BusDto>> viewAllBuses(){
        List<BusDto> buses=busService.viewAllBuses();
        return new ResponseEntity<>(buses,HttpStatus.OK);
    }




    }
