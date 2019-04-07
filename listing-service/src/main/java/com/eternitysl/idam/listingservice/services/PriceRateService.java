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

    public List<PriceRate> getAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("All availability types started to return");
        }
        return priceRateRepository.findAll();
    }

    public PriceRate getAvailabilityType(String stringId) {

        List<PriceRate> priceRates = priceRateRepository.findByName(stringId);
        if (priceRates.isEmpty()) {
            throw new ResourceNotFoundException("Availability", "name", stringId);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s ListingType responded", priceRates.get(0)));
        }

        return priceRates.get(0);
    }

    public PriceRate create(PriceRate priceRate) {
        if (isExists(priceRate.getName())) {
            throw new ResourceDuplicateException("PriceRate", "name", priceRate.getName());
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Create PriceRate %s ", priceRate.getName()));
        }

        return priceRateRepository.save(priceRate);
    }

    public PriceRate update(String stringId, PriceRate priceRate) {
        PriceRate priceRateSearched = this.getAvailabilityType(stringId);

        if (isExists(priceRate.getName())) {
            throw new ResourceDuplicateException("PriceRate", "name", priceRate.getName());
        }

        priceRateSearched.setMainType(priceRate.getMainType());
        priceRateSearched.setName(priceRate.getName());

        return priceRateRepository.save(priceRateSearched);
    }

    public boolean delete(String stringId) {
        PriceRate priceRateSearched = getAvailabilityType(stringId);
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
