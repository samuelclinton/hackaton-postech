package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.api.model.user.UserInputDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.exception.UserIsMissingDocumentException;
import com.cloudinn.backend.domain.exception.UserIsNotUniqueException;
import com.cloudinn.backend.domain.model.User;
import com.cloudinn.backend.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.cloudinn.backend.utils.UserHelper.*;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DomainEntityMapperImpl<UserInputDto, OutputDto, User> userMapper;

    @BeforeEach
    void setup() {
        this.userRepository.deleteAll();
    }

    @Test
    void create_shouldPersistUser() {
        var newUser = generateDefaultUser();
        var result = userService.create(newUser);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertTrue(result.getId() >= 1L);
    }

    @Test
    void update_shouldUpdateUserProperties() {
        var persistedUser = persistDefaultUser();
        var updatedUser = userMapper.mapInputToEntity(generateUpdateUserDto(), User.class);

        var result = userService.update(persistedUser.getId(), updatedUser);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(persistedUser.getId(), result.getId());
        assertEquals("BR", result.getCountry());
        assertEquals("Updated Name", result.getName());
        assertEquals("new_email@email.com", result.getEmail());
    }

    @Test
    void create_shouldThrowExceptionIfUserIsNotUnique() {
        persistDefaultUser();
        var newUser = generateDefaultUser();
        assertThrows(UserIsNotUniqueException.class, () -> userService.create(newUser));
    }

    @Test
    void create_shouldThrowExceptionIfUserIsBrazilianAndDoesntHaveCpf() {
        var newUser = generateDefaultUser();
        newUser.setCpf(null);
        assertThrows(UserIsMissingDocumentException.class, () -> userService.create(newUser));
    }

    @Test
    void create_shouldThrowExceptionIfUserIsFromAbroadAndDoesntHavePassport() {
        var newUser = generateDefaultUser();
        newUser.setCountry("US");
        assertThrows(UserIsMissingDocumentException.class, () -> userService.create(newUser));
    }

    private User persistDefaultUser() {
        return userRepository.save(generateDefaultUser());
    }

    private User generateDefaultUser() {
        return userMapper.mapInputToEntity(generateNewUserDto(), User.class);
    }

}
