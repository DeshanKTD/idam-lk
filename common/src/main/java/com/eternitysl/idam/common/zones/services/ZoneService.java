package com.eternitysl.idam.common.zones.services;

import com.eternitysl.idam.common.exceptions.ResourceDuplicateException;
import com.eternitysl.idam.common.exceptions.ResourceNotFoundException;
import com.eternitysl.idam.common.zones.entities.District;
import com.eternitysl.idam.common.zones.entities.Town;
import com.eternitysl.idam.common.zones.repositories.DistrictRepository;
import com.eternitysl.idam.common.zones.repositories.TownRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    private static final Logger LOGGER = LogManager.getLogger(ZoneService.class.getName());

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private TownRepository townRepository;

    public List<District> getAllDistricts() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All availability types started to return");
        }

        return districtRepository.findAll();
    }

    public List<Town> getAllTowns() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All availability types started to return");
        }

        return townRepository.findAll();
    }



    public District getSingleDistrict(String stringId){
        List<District> districts = districtRepository.findByName(stringId);

        if(districts.isEmpty()){
            throw new ResourceNotFoundException("District","name",stringId);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s district responded", districts.get(0)));
        }

        return districts.get(0);
    }

    public Town getSingleTown(String stringId){
        List<Town> towns = townRepository.findByName(stringId);

        if(towns.isEmpty()){
            throw new ResourceNotFoundException("District","name",stringId);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s towns responded", towns.get(0)));
        }

        return towns.get(0);
    }


    public District createDistrict(District district){
        if(isDistrictExists(district.getName())){
            throw new ResourceDuplicateException("District","name", district.getName() );
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create District %s ", district.getName()));
        }

        return districtRepository.save(district);
    }


    public Town createTown(Town town){
        if(isTownExists(town.getName())){
            throw new ResourceDuplicateException("Town","name",town.getName());
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create Town %s ", town.getName()));
        }
        return townRepository.save(town);
    }


    public District updateDistrict(String stringId, District district){
        District searchedDistrict = this.getSingleDistrict(stringId);

        if(isDistrictExists(district.getName())){
            throw  new ResourceDuplicateException("District","name",district.getName());
        }

        searchedDistrict.setName(district.getName());

        return districtRepository.save(searchedDistrict);
    }


    public Town updateTown(String stringId, Town town){
        Town searchedTown = this.getSingleTown(stringId);

        if(isTownExists(town.getName())){
            throw new ResourceDuplicateException("Town","name", town.getName());
        }

        searchedTown.setName(town.getName());
        searchedTown.setDistrict(town.getDistrict());

        return townRepository.save(searchedTown);
    }


    public boolean deleteDistrict(String stringId){
        District searhcedDistrict = getSingleDistrict(stringId);
        districtRepository.delete(searhcedDistrict);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }


    public boolean deleteTown(String stringId){
        Town searhcedTown = getSingleTown(stringId);
        townRepository.delete(searhcedTown);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }



    private boolean isDistrictExists(String stringId){
        List<District> districts = districtRepository.findByName(stringId);
        if(districts.isEmpty()){
            return false;
        }
        return true;
    }

    private boolean isTownExists(String stringId){
        List<Town> town = townRepository.findByName(stringId);
        if(town.isEmpty()){
            return false;
        }
        return true;
    }

}
