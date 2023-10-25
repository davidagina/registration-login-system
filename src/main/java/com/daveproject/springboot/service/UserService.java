package com.daveproject.springboot.service;

import com.daveproject.springboot.dto.UserDto;
import com.daveproject.springboot.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
