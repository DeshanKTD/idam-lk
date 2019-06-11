package com.eternitysl.idam.listingservice.repositories;

import com.eternitysl.idam.listingservice.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing,Long> {
}
