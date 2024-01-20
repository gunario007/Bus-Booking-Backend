package com.AbiBus.busBooking.service;

import com.AbiBus.busBooking.dto.UserDto;
import com.AbiBus.busBooking.dto.UserLoginDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);







    






}
