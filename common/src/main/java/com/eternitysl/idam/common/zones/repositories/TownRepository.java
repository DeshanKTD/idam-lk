package com.eternitysl.idam.common.zones.repositories;

import com.eternitysl.idam.common.zones.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town,Long> {
    List<Town> findByName(String stringId);
}
