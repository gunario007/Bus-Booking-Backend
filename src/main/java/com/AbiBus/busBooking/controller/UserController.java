package com.AbiBus.busBooking.controller;


import com.AbiBus.busBooking.dto.UserDto;
import com.AbiBus.busBooking.dto.UserLoginDto;
import com.AbiBus.busBooking.service.UserService;
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
        name = "CRUD API's for User Resource"

)

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;


    @Operation(
            summary = "Create User Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )

    @PostMapping
    public ResponseEntity<UserDto> createdUser(@RequestBody @Valid UserDto userDto){
        UserDto createUser=userService.createUser(userDto);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);

    }
    @Operation(
            summary = "Get User Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(
            summary = "Get All User Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 OK"
    )

    @GetMapping
    public ResponseEntity<List<UserDto>> getUser(){
        List<UserDto> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(
            summary = "Update an User Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                                   @RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser=userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    @Operation(
            summary = "Delete an User Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }




}
