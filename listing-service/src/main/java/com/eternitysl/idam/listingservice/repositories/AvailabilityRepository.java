package com.eternitysl.idam.listingservice.repositories;

import com.eternitysl.idam.listingservice.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByName(String stringId);
}
