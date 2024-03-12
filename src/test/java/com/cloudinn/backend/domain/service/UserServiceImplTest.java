package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.exception.UserIsMissingDocumentException;
import com.cloudinn.backend.domain.exception.UserIsNotUniqueException;
import com.cloudinn.backend.domain.model.User;
import com.cloudinn.backend.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cloudinn.backend.utils.UserHelper.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        this.userRepository = mock(UserRepository.class);
        this.userService = new UserServiceImpl(this.userRepository);
    }

    @Test
    void create_shouldPersistUser() {
        var newUserDto = generateNewUserDto();
        var newUser = new User(newUserDto);
        var returnedUser = new User(newUserDto);
        returnedUser.setId(USER_ID);

        when(userRepository.existsByEmailOrCpfOrPassport(newUser.getEmail(), newUser.getCpf(), newUser.getPassport()))
                .thenReturn(false);
        when(userRepository.save(newUser)).thenReturn(returnedUser);

        var result = userService.create(newUser);

        assertNotNull(result);
        assertEquals(USER_ID, result.getId());
        verify(userRepository, times(1)).save(newUser);
        verify(userRepository, times(1))
                .existsByEmailOrCpfOrPassport(newUser.getEmail(), newUser.getCpf(), newUser.getPassport());
    }

    @Test
    void create_shouldThrowExceptionIfUserIsNotUnique() {
        var newUserDto = generateNewUserDto();
        var newUser = new User(newUserDto);

        when(userRepository.existsByEmailOrCpfOrPassport(newUser.getEmail(), newUser.getCpf(), newUser.getPassport()))
                .thenReturn(true);

        assertThrows(UserIsNotUniqueException.class, () -> userService.create(newUser));
    }

    @Test
    void create_shouldThrowExceptionIfUserIsBrazilianAndDoesntHaveCpf() {
        var newUserDto = generateNewUserDto();
        var newUser = new User(newUserDto);
        newUser.setCpf(null);

        when(userRepository.existsByEmailOrCpfOrPassport(newUser.getEmail(), newUser.getCpf(), newUser.getPassport()))
                .thenReturn(false);

        assertThrows(UserIsMissingDocumentException.class, () -> userService.create(newUser));
    }

    @Test
    void create_shouldThrowExceptionIfUserIsFromAbroadAndDoesntHavePassport() {
        var newUserDto = generateNewUserDto();
        var newUser = new User(newUserDto);
        newUser.setCountry("US");

        when(userRepository.existsByEmailOrCpfOrPassport(newUser.getEmail(), newUser.getCpf(), newUser.getPassport()))
                .thenReturn(false);

        assertThrows(UserIsMissingDocumentException.class, () -> userService.create(newUser));
    }

}
