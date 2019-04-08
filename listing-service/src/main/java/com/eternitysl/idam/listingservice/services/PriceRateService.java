package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.exceptions.ResourceDuplicateException;
import com.eternitysl.idam.listingservice.exceptions.ResourceNotFoundException;
import com.eternitysl.idam.listingservice.repositories.PriceRateRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceRateService {

    private static final Logger LOGGER = LogManager.getLogger(PriceRateService.class.getName());

    @Autowired
    private PriceRateRepository priceRateRepository;

    /**
     * Get all price rates
     *
     * @return list of price rates
     */
    public List<PriceRate> getAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All availability types started to return");
        }
        return priceRateRepository.findAll();
    }

    /**
     * Get a selected price rate
     *
     * @param stringId - price rate Id
     * @return PriceRate object
     */
    public PriceRate getPriceRate(String stringId) {

        List<PriceRate> priceRates = priceRateRepository.findByName(stringId);
        if (priceRates.isEmpty()) {
            throw new ResourceNotFoundException("Availability", "name", stringId);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s ListingType responded", priceRates.get(0)));
        }

        return priceRates.get(0);
    }

    /**
     * Create a new price rate
     *
     * @param priceRate - PriceRate object
     * @return created price rate object
     */
    public PriceRate create(PriceRate priceRate) {
        if (isExists(priceRate.getName())) {
            throw new ResourceDuplicateException("PriceRate", "name", priceRate.getName());
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create PriceRate %s ", priceRate.getName()));
        }

        return priceRateRepository.save(priceRate);
    }

    /**
     * Update a price rate
     * @param stringId - Update price rate id
     * @param priceRate - Changed PriceRate object
     * @return updated price rate object
     */
    public PriceRate update(String stringId, PriceRate priceRate) {
        PriceRate priceRateSearched = this.getPriceRate(stringId);

        if (isExists(priceRate.getName())) {
            throw new ResourceDuplicateException("PriceRate", "name", priceRate.getName());
        }

        priceRateSearched.setMainType(priceRate.getMainType());
        priceRateSearched.setName(priceRate.getName());

        return priceRateRepository.save(priceRateSearched);
    }


    /**
     * Delete a price rate
     * @param stringId
     * @return
     */
    public boolean delete(String stringId) {
        PriceRate priceRateSearched = getPriceRate(stringId);
        priceRateRepository.delete(priceRateSearched);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s deleted successfully", stringId));
        }

        return true;
    }

    private boolean isExists(String stringId) {
        List<PriceRate> priceRates = priceRateRepository.findByName(stringId);
        if (priceRates.isEmpty())
            return false;

        return true;
    }
}
