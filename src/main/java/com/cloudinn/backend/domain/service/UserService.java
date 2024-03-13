package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.model.User;

public interface UserService {

    User create(User user);
    User get(Long id);
    User update(Long id, User updatedUser);
    void delete(Long id);

}
