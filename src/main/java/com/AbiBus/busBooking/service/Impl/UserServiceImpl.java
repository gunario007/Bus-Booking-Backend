package com.AbiBus.busBooking.service.Impl;

import com.AbiBus.busBooking.Mapper.UserMapper;
import com.AbiBus.busBooking.Models.User;
import com.AbiBus.busBooking.dto.UserDto;
import com.AbiBus.busBooking.dto.UserLoginDto;
import com.AbiBus.busBooking.exception.ResourceNotFoundException;
import com.AbiBus.busBooking.repository.UserRepo;
import com.AbiBus.busBooking.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepo userRepo;
    private ModelMapper modelMapper;



    @Override
    public UserDto createUser(UserDto userDto) {

//        User user=UserMapper.mapToUser(userDto);

        User user=modelMapper.map(userDto,User.class);



        User createUser=userRepo.save(user);

//        UserDto createUserDto=UserMapper.mapToUserDto(user);
        UserDto createUserDto=modelMapper.map(user, UserDto.class);

        return createUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user","id",userId));
        return modelMapper.map(user,UserDto.class);
    }



    @Override
    public List<UserDto> getAllUsers() {

        List<User> users=userRepo.findAll();
        List<UserDto> userDtos= users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

//        User user=UserMapper.mapToUser(userDto);
        User user=modelMapper.map(userDto,User.class);


        User existingUser = userRepo.findById(user.getId()).
                orElseThrow(()->new ResourceNotFoundException("user","id",user.getId()));
        existingUser.setName(user.getName());


        existingUser.setGender(user.getGender());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        existingUser.setPassword(user.getPassword());

        User updatedUser=userRepo.save(existingUser);

//        UserDto updatedUserDto=UserMapper.mapToUserDto(updatedUser);
        UserDto updatedUserDto=modelMapper.map(updatedUser, UserDto.class);

        return updatedUserDto;
    }

    @Override
    public void deleteUser(Long userId) {

        User existingUser = userRepo.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("user","id",userId));

        userRepo.deleteById(existingUser.getId());

    }
}
