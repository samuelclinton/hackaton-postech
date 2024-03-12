package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.exception.UserIsMissingDocumentException;
import com.cloudinn.backend.domain.exception.UserIsNotUniqueException;
import com.cloudinn.backend.domain.model.User;
import com.cloudinn.backend.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
    void update_shouldUpdateUserProperties() {
        var newUserDto = generateNewUserDto();

        var existingUser = new User(newUserDto);
        existingUser.setId(USER_ID);

        var updatedUser = new User(newUserDto);
        updatedUser.setName("Updated Name");
        updatedUser.setEmail("new_email@email.com");
        updatedUser.setCountry("US");

        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        var result = userService.update(USER_ID, updatedUser);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(USER_ID, result.getId());
        assertEquals("BR", result.getCountry());
        assertEquals("Updated Name", result.getName());
        assertEquals("new_email@email.com", result.getEmail());
        verify(userRepository, times(1)).findById(USER_ID);
        verify(userRepository, times(1)).save(existingUser);
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
