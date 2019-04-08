package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.exceptions.ResourceDuplicateException;
import com.eternitysl.idam.listingservice.exceptions.ResourceNotFoundException;
import com.eternitysl.idam.listingservice.repositories.AvailabilityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {
    private static final Logger LOGGER = LogManager.getLogger(AvailabilityService.class.getName());

    @Autowired
    private AvailabilityRepository availabilityRepository;

    /**
     * Get all availability types
     *
     * @return List of Availability
     */
    public List<Availability> getAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All availability types started to return");
        }
        return availabilityRepository.findAll();
    }


    /**
     * Get specific availability type
     *
     * @param stringId - String ID by ID
     * @return Selected Availability type
     */
    public Availability getAvailabilityType(String stringId) {

        List<Availability> availabilities = availabilityRepository.findByName(stringId);
        if (availabilities.isEmpty()) {
            throw new ResourceNotFoundException("Availability", "name", stringId);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s ListingType responded", availabilities.get(0)));
        }

        return availabilities.get(0);
    }


    /**
     * Create a new Availability type
     *
     * @param availability - Availability type
     * @return Created Availability object
     */
    public Availability create(Availability availability) {
        if (isExists(availability.getName())) {
            throw new ResourceDuplicateException("Availability", "name", availability.getName());
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create ListingType %s ", availability.getName()));
        }

        return availabilityRepository.save(availability);
    }


    /**
     * Update a Availability
     *
     * @param stringId     - availability string id
     * @param availability - changing availability object
     * @return changed Availability object
     */
    public Availability update(String stringId, Availability availability) {
        Availability availabilitySearched = this.getAvailabilityType(stringId);

        if (isExists(availability.getName())) {
            throw new ResourceDuplicateException("Availability", "name", availability.getName());
        }

        availabilitySearched.setMainType(availability.getMainType());
        availabilitySearched.setName(availability.getName());

        return availabilityRepository.save(availabilitySearched);
    }

    /**
     * Delete existing Availability type
     *
     * @param stringId - Deleted availability ID
     * @return True if success
     */
    public boolean delete(String stringId) {
        Availability listingTypeSearched = getAvailabilityType(stringId);
        availabilityRepository.delete(listingTypeSearched);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }

    private boolean isExists(String stringId) {
        List<Availability> availabilities = availabilityRepository.findByName(stringId);
        if (availabilities.isEmpty())
            return false;

        return true;
    }
}
