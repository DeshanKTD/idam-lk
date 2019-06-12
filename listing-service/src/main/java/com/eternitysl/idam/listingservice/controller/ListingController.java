package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.listing.ListingInboundDTO;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.services.ListingService;
import com.eternitysl.idam.listingservice.services.entitybuilders.ListingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/listing")
@RestController
public class ListingController {

    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingBuilder listingBuilder;

    @PostMapping
    public Listing createListing(@Valid @RequestBody ListingInboundDTO listingInboundDTO) {
        Listing listing = listingBuilder.createListing(listingInboundDTO);
        return listingService.create(listing);
    }
}
