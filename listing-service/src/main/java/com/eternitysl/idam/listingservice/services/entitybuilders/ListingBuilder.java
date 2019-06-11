package com.eternitysl.idam.listingservice.services.entitybuilders;

import com.eternitysl.idam.listingservice.dto.listing.ListingInboundDTO;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.entities.constants.SellerType;
import com.eternitysl.idam.listingservice.services.ListingSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingBuilder {

    @Autowired
    private static ListingSubTypeService listingSubTypeService;

    public static Listing createListing(ListingInboundDTO listingInboundDTO){
        Listing listing = new Listing();
        listing.setAddedBy(listingInboundDTO.getAddedBy());
        listing.setTitle(listingInboundDTO.getTitle());
        listing.setDescription(listingInboundDTO.getDescription());
        listing.setSellerType(SellerType.fromValue(listingInboundDTO.getSellerType()));
        listing.setPrice(listingInboundDTO.getPrice());
        listing.setContactName(listingInboundDTO.getContactName());
        listing.setContactNumber(listingInboundDTO.getContactNumber());
        listing.setListingSubType(listingSubTypeService.getSubTypeById(listingInboundDTO.getListingSubType()));
        listing.setLandListing(LandListingBuilder.createLandListing(listingInboundDTO.getLandListing()));
        listing.setBuildingListing(BuildingListingBuilder.createBuildingListing(listingInboundDTO.getBuildingListing()));

        return listing;
    }
}
