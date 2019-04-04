package com.eternitysl.idam.listingservice.repositories;

import com.eternitysl.idam.listingservice.entities.ListingSubType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingSubTypeRepository extends JpaRepository<ListingSubType,Long> {
    List<ListingSubType> findByName(String name);
}
