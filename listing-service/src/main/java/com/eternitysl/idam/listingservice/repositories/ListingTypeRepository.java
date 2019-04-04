package com.eternitysl.idam.listingservice.repositories;

import com.eternitysl.idam.listingservice.entities.ListingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingTypeRepository extends JpaRepository<ListingType, Long> {
    List<ListingType> findByName(String name);
}
