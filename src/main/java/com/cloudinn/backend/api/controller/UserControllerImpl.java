package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.user.NewUserDto;
import com.cloudinn.backend.api.model.user.UpdateUserDto;
import com.cloudinn.backend.api.model.user.UserDto;
import com.cloudinn.backend.api.model.user.UserInputDto;
import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.domain.model.User;
import com.cloudinn.backend.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final DomainEntityMapperImpl<UserInputDto, UserDto, User> userMapper;

    public UserControllerImpl(UserService userService, DomainEntityMapperImpl<UserInputDto, UserDto, User> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid NewUserDto newUserDto) {
        User createdUser = userMapper.mapInputToEntity(newUserDto, User.class);
        return userMapper.mapEntityToOutput(userService.create(createdUser), UserDto.class);
    }

    @Override
    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody @Valid UpdateUserDto updateUserDto) {
        User updatedUser = userService.update(id, userMapper.mapInputToEntity(updateUserDto, User.class));
        return userMapper.mapEntityToOutput(updatedUser, UserDto.class);
    }

    @Override
    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userMapper.mapEntityToOutput(userService.get(id), UserDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
