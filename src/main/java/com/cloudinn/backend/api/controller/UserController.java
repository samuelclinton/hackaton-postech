package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.user.NewUserDto;
import com.cloudinn.backend.api.model.user.UpdateUserDto;
import com.cloudinn.backend.api.model.user.UserDto;

public interface UserController {

    UserDto create(NewUserDto newUserDto);
    UserDto update(Long id, UpdateUserDto updateUserDto);
    UserDto get(Long id);
    void delete(Long id);

}
