package com.eternitysl.idam.common.zones.repositories;

import com.eternitysl.idam.common.zones.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
    List<District> findByName(String stringId);
}
