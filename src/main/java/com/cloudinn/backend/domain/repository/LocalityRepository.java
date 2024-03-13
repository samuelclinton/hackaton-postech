package com.cloudinn.backend.domain.repository;

import com.cloudinn.backend.domain.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Location, Long> {
}
