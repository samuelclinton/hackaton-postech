package com.cloudinn.backend.domain.repository;

import com.cloudinn.backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailOrCpfOrPassport(String email, String cpf, String passport);

}
