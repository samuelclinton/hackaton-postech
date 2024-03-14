package com.cloudinn.backend.domain.repository;

import com.cloudinn.backend.domain.model.AddedOptional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddedOptionalRepository extends JpaRepository<AddedOptional, Long> {
}
