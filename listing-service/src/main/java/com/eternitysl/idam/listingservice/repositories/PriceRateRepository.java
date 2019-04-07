package com.eternitysl.idam.listingservice.repositories;

import com.eternitysl.idam.listingservice.entities.PriceRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRateRepository extends JpaRepository<PriceRate,Long> {
    List<PriceRate> findByName(String stringId);
}
