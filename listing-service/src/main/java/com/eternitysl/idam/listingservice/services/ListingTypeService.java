package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.exceptions.ResourceDuplicateException;
import com.eternitysl.idam.listingservice.exceptions.ResourceNotFoundException;
import com.eternitysl.idam.listingservice.repositories.ListingTypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingTypeService {

    private static final Logger LOGGER = LogManager.getLogger(ListingTypeService.class.getName());

    @Autowired
    ListingTypeRepository listingTypeRepository;

    /**
     * Retrieve all Listing Types
     *
     * @return List of ListingType objects
     */
    public List<ListingType> getAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All listing types started to return");
        }
        return listingTypeRepository.findAll();
    }

    /**
     * Retrieve Listing Type by its code name (stringId)
     *
     * @param stringId String codename
     * @return ListingType object for given stringId
     */
    public ListingType getListingType(String stringId) {

        List<ListingType> listingType = listingTypeRepository.findByName(stringId);
        if (listingType.isEmpty())
            throw new ResourceNotFoundException("ListingType", "name", stringId);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s ListingType responded", listingType.get(0)));
        }

        return listingType.get(0);
    }

    /**
     * Create a new ListingType
     *
     * @param listingType ListingType object with relevant properties
     * @return Created ListingType
     */
    public ListingType create(ListingType listingType) {
        if (isExists(listingType.getName())) {
            throw new ResourceDuplicateException("ListingType", "name", listingType.getName());
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create ListingType %s ", listingType.getName()));
        }

        return listingTypeRepository.save(listingType);
    }

    /**
     * Update a existing ListingType
     *
     * @param stringId    - String Id of the listing type
     * @param listingType - ListingType object with updating values
     * @return updated ListingType object
     */
    public ListingType update(String stringId, ListingType listingType) {
        ListingType listingTypeSearched = getListingType(stringId);

        if (isExists(listingType.getName())) {
            throw new ResourceDuplicateException("ListingType", "name", listingType.getName());
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Updating ListingType %s ", stringId));
        }
        listingTypeSearched.setName(listingType.getName());
        ListingType updateListingType = listingTypeRepository.save(listingTypeSearched);

        return updateListingType;
    }

    /**
     * Delete a listing type
     *
     * @param stringId - String Id of the listing type
     * @return boolean for success deletion
     */
    public boolean delete(String stringId) {
        ListingType listingTypeSearched = getListingType(stringId);
        listingTypeRepository.delete(listingTypeSearched);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }


    private boolean isExists(String stringId) {
        List<ListingType> listingType = listingTypeRepository.findByName(stringId);
        if (listingType.isEmpty())
            return false;
        return true;
    }

}
