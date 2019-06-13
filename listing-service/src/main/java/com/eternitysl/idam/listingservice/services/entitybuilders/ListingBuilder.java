package com.eternitysl.idam.listingservice.services.entitybuilders;

import com.eternitysl.idam.listingservice.dto.listing.ListingInboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.ListingOutboundDTO;
import com.eternitysl.idam.listingservice.dto.listingsubtype.ListingSubTypeSummaryDTO;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.entities.constants.SellerType;
import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.eternitysl.idam.listingservice.entities.listings.LandListing;
import com.eternitysl.idam.listingservice.services.ListingSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingBuilder {

    @Autowired
    private ListingSubTypeService listingSubTypeService;

    @Autowired
    private LandListingBuilder landListingBuilder;

    @Autowired
    private BuildingListingBuilder buildingListingBuilder;

    public Listing createListingFromInboundDTO(ListingInboundDTO listingInboundDTO){
        Listing listing = new Listing();
        listing.setAddedBy(listingInboundDTO.getAddedBy());
        listing.setTitle(listingInboundDTO.getTitle());
        listing.setDescription(listingInboundDTO.getDescription());
        listing.setSellerType(SellerType.fromValue(listingInboundDTO.getSellerType()));
        listing.setPrice(listingInboundDTO.getPrice());
        listing.setContactName(listingInboundDTO.getContactName());
        listing.setContactNumber(listingInboundDTO.getContactNumber());
        listing.setListingSubType(listingSubTypeService.getSubTypeById(listingInboundDTO.getListingSubType()));
        if(listingInboundDTO.getLandListing()!=null) {
            LandListing landListing =landListingBuilder.createLandListingFromInboundDTO(listingInboundDTO.getLandListing());
            landListing.setListing(listing);
            listing.setLandListing(landListing);
        }
        if(listingInboundDTO.getBuildingListing()!=null) {
            BuildingListing buildingListing = buildingListingBuilder.createBuildingListingFromInboundDTO(listingInboundDTO.getBuildingListing());
            buildingListing.setListing(listing);
            listing.setBuildingListing(buildingListing);

        }

        return listing;
    }

    public ListingOutboundDTO createListingOutboundDTOFromListing(Listing listing){
        ListingOutboundDTO listingOutboundDTO = new ListingOutboundDTO();
        listingOutboundDTO.setAddedBy(listing.getAddedBy());
        listingOutboundDTO.setTitle(listing.getTitle());
        listingOutboundDTO.setDescription(listing.getDescription());
        listingOutboundDTO.setSellerType(listing.getSellerType());
        listingOutboundDTO.setPrice(listing.getPrice());
        listingOutboundDTO.setContactName(listing.getContactName());
        listingOutboundDTO.setContactNumber(listing.getContactNumber());
        listingOutboundDTO.setNameUri(listing.getNameUri());
        listingOutboundDTO.setListingSubType(ListingSubTypeSummaryDTO.populate(listing.getListingSubType()));
        listingOutboundDTO.setCreatedAt(listing.getCreatedAt());
        if(listing.getBuildingListing()!=null){
            listingOutboundDTO.setBuildingListing(buildingListingBuilder.createOutboundDTOFromBuidingListing(
                    listing.getBuildingListing()
            ));
        }
        if(listing.getLandListing()!=null){
            listingOutboundDTO.setLandListing(landListingBuilder.createOutboundDTOFromLandListing(
                    listing.getLandListing()
            ));
        }

        return listingOutboundDTO;

    }
}
