package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.model.User;

public interface UserService {

    User create(User user);
    User get(String id);
    User update(String id, User updatedUser);
    void delete(String id);

}
