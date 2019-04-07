package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.ListingSubType;
import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.exceptions.ResourceDuplicateException;
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
        if(isExists(listingSubType.getName())){
            throw new ResourceDuplicateException("ListingSubType","name",listingSubType.getName());
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create ListingSubType %s ", listingSubType.getName()));
        }

        return listingSubTypeRepository.save(listingSubType);

    }


    public ListingSubType update(String stringId, ListingSubType listingSubType){
        ListingSubType listingSubTypeSearched = this.getSubTypeById(stringId);

        if(isExists(listingSubType.getName())){
            throw new ResourceDuplicateException("ListingSubType","name",listingSubType.getName());
        }

        listingSubTypeSearched.setMainType(listingSubType.getMainType());
        listingSubTypeSearched.setName(listingSubType.getName());

        ListingSubType updatedList = listingSubTypeRepository.save(listingSubTypeSearched);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Updating ListingSubType %s ", stringId));
        }

        return updatedList;
    }

    public boolean delete(String stringId){
        ListingSubType listingSubType = this.getSubTypeById(stringId);
        listingSubTypeRepository.delete(listingSubType);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }

    private boolean isExists(String stringId) {
        List<ListingSubType> listingType = listingSubTypeRepository.findByName(stringId);
        if (listingType.isEmpty())
            return false;
        return true;
    }







}
