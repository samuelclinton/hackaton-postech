package com.cloudinn.backend.domain.repository;

import com.cloudinn.backend.domain.model.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionalRepository extends JpaRepository<Optional, Long> {
}
