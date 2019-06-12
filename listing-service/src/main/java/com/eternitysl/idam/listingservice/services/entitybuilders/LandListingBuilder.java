package com.eternitysl.idam.listingservice.services.entitybuilders;

import com.eternitysl.idam.listingservice.dto.listing.land.LandListingInboundDTO;
import com.eternitysl.idam.listingservice.entities.listings.LandListing;
import com.eternitysl.idam.listingservice.entities.listings.landlisting.LandSellingType;
import com.eternitysl.idam.listingservice.services.AvailabilityService;
import com.eternitysl.idam.listingservice.services.PriceRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandListingBuilder {

    @Autowired
    private  PriceRateService priceRateService;

    @Autowired
    private  AvailabilityService availabilityService;

    public LandListing createLandListing(LandListingInboundDTO landListingInboundDTO){
        LandListing landListing = new LandListing();
        landListing.setLandArea(landListingInboundDTO.getLandArea());
        landListing.setLandAreaUnit(landListingInboundDTO.getLandAreaUnit());
        landListing.setPriceRate(priceRateService.getPriceRate(landListingInboundDTO.getPriceRate()));
        landListing.setAvailability(availabilityService.getAvailabilityType(landListingInboundDTO.getAvailability()));
        landListing.setLandSellingType(LandSellingType.fromValue(landListingInboundDTO.getLandSellingType()));

        return landListing;
    }
}
