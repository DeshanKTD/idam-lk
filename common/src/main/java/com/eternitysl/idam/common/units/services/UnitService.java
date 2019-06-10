package com.eternitysl.idam.common.units.services;

import com.eternitysl.idam.common.exceptions.ResourceDuplicateException;
import com.eternitysl.idam.common.exceptions.ResourceNotFoundException;
import com.eternitysl.idam.common.units.entities.Unit;
import com.eternitysl.idam.common.units.entities.UnitType;
import com.eternitysl.idam.common.units.repositories.UnitRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {
    private static final Logger LOGGER = LogManager.getLogger(UnitService.class.getName());

    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits(){
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All units started to return");
        }

        return unitRepository.findAll();
    }

    public List<Unit> getUnitByType(UnitType unitType){
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s is searching", unitType.toString()));
        }

        return unitRepository.findAll();
    }

    public Unit getSingleUnit(String stringId){
        List<Unit> units = unitRepository.findByName(stringId);

        if(units.isEmpty()){
            throw new ResourceNotFoundException("Unit","name",stringId);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s district responded", units.get(0)));
        }

        return units.get(0);
    }

    public Unit createUnit(Unit unit){
        if(isUnitExists(unit.getName())){
            throw new ResourceDuplicateException("Unit","name",unit.getName());
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create Unit %s ", unit.getName()));
        }

        return unitRepository.save(unit);
    }

    public Unit updateAdUnit(String stringId,Unit unit){
        Unit searchedUnit = this.getSingleUnit(stringId);

        try {
            Unit changeUnit = this.getSingleUnit(unit.getName());

            if(searchedUnit.getId()==changeUnit.getId()){
                searchedUnit.setUnit(unit.getUnit());
                searchedUnit.setUnitType(unit.getUnitType());
            }

        } catch (ResourceNotFoundException e) {
            searchedUnit.setUnit(unit.getUnit());
            searchedUnit.setUnitType(unit.getUnitType());
            searchedUnit.setName(unit.getName());
        }


        return unitRepository.save(searchedUnit);
    }

    public boolean deleteUnit(String stringId){
        Unit searchedUnit = getSingleUnit(stringId);
        unitRepository.delete(searchedUnit);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }


    public List<String> getAllUnitTypes(){
        List<String> unitTypeList = new ArrayList<>();
        for(UnitType unitType: UnitType.values()){
            unitTypeList.add(unitType.name());
        }
        return unitTypeList;
    }

    private boolean isUnitExists(String string){
        List<Unit> unit = unitRepository.findByName(string);
        if(unit.isEmpty()){
            return false;
        }
        return true;
    }
}
