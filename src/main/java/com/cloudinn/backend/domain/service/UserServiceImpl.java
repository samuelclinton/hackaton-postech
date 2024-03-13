package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.api.data.DomainEntityMapperImpl;
import com.cloudinn.backend.api.model.user.UserInputDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.exception.UserIsMissingDocumentException;
import com.cloudinn.backend.domain.exception.UserIsNotUniqueException;
import com.cloudinn.backend.domain.exception.UserNotFoundException;
import com.cloudinn.backend.domain.model.User;
import com.cloudinn.backend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DomainEntityMapperImpl<UserInputDto, OutputDto, User> userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           DomainEntityMapperImpl<UserInputDto, OutputDto, User> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
    public User get(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Nenhum usuário encontrado com o id " + id));
    }

    @Override
    @Transactional
    public User update(Long id, User updatedUser) {
        User existingUser = get(id);
        userMapper.copyPropertiesBetweenEntities(updatedUser, existingUser);
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(get(id));
    }

}
