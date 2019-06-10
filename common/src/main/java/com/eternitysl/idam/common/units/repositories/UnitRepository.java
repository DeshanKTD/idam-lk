package com.eternitysl.idam.common.units.repositories;

import com.eternitysl.idam.common.units.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Long> {
    List<Unit> findByName(String string);
}
