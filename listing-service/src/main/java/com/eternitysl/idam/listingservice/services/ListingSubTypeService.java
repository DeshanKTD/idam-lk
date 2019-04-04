package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.ListingSubType;
import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.exceptions.ResourceNotFoundException;
import com.eternitysl.idam.listingservice.repositories.ListingSubTypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingSubTypeService {

    private static final Logger LOGGER = LogManager.getLogger(ListingSubTypeService.class.getName());


    @Autowired
    ListingSubTypeRepository listingSubTypeRepository;

    @Autowired
    ListingTypeService listingTypeService;

    /**
     * Get all listing sub types
     *
     * @return ListingSubType objects
     */
    public List<ListingSubType> getAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All sub listing types started to return");
        }
        return listingSubTypeRepository.findAll();
    }

    /**
     * Get sub listing type by id
     * @param stringId - string id of sub listing type
     * @return ListingSubType object
     */
    public ListingSubType getSubTypeById(String stringId) {
        List<ListingSubType> listingSubTypes = listingSubTypeRepository.findByName(stringId);
        if (listingSubTypes.isEmpty())
            throw new ResourceNotFoundException("ListingSubType", "name", stringId);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s ListingType responded", listingSubTypes.get(0)));
        }

        return listingSubTypes.get(0);

    }

    public ListingSubType create(ListingSubType listingSubType){

        return listingSubTypeRepository.save(listingSubType);

    }







}
