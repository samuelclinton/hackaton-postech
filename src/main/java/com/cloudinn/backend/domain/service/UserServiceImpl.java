package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.exception.UserIsMissingDocumentException;
import com.cloudinn.backend.domain.exception.UserIsNotUniqueException;
import com.cloudinn.backend.domain.exception.UserNotFoundException;
import com.cloudinn.backend.domain.model.User;
import com.cloudinn.backend.domain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User create(User user) {
        if (userIsUnique(user)) {
            if (userHasRequiredDocument(user)) {
                return userRepository.save(user);
            } else {
                throw new UserIsMissingDocumentException(
                        "Você precisa preencher corretamente o documento CPF (para brasileiros) ou passaporte (para estrangeiros)");
            }
        } else {
            throw new UserIsNotUniqueException("Já existe um usuário cadastrado com este e-mail, CPF ou passaporte");
        }
    }

    private boolean userIsUnique(User user) {
        return !userRepository.existsByEmailOrCpfOrPassport(user.getEmail(), user.getCpf(), user.getPassport());
    }

    private boolean userHasRequiredDocument(User user) {

        boolean userIsBrazilian = user.getCountry().equals("BR");
        String cpf = user.getCpf();
        String passport = user.getPassport();

        if (userIsBrazilian) {
            return cpf != null && !cpf.isEmpty();
        } else {
            return passport != null && !user.getPassport().isEmpty();
        }

    }

    @Override
    public User get(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Nenhum usuário encontrado com o id " + id));
    }

    @Override
    @Transactional
    public User update(String id, User updatedUser) {
        User existingUser = get(id);
        BeanUtils.copyProperties(updatedUser, existingUser, "id", "cpf", "passport", "country");
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void delete(String id) {
        userRepository.delete(get(id));
    }

}
