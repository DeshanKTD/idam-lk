package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Service
public class ListingService {

    private static final Logger LOGGER = LogManager.getLogger(ListingService.class.getName());

    @Autowired
    private ListingRepository listingRepository;

    public Listing create(Listing listing){
        return listingRepository.save(listing);
    }


}
