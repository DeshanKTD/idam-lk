package com.eternitysl.idam.listingservice.dto.listing;

import com.eternitysl.idam.listingservice.dto.listing.building.BuildingListingOutboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.land.LandListingOutboundDTO;
import com.eternitysl.idam.listingservice.dto.listingsubtype.ListingSubTypeSummaryDTO;
import com.eternitysl.idam.listingservice.entities.constants.SellerType;

import java.util.Date;

public class ListingOutboundDTO {
    private String addedBy;
    private String title;
    private String description;
    private SellerType sellerType;
    private int price;
    private String contactName;
    private String contactNumber;
    private String nameUri;
    private ListingSubTypeSummaryDTO listingSubType;
    private Date createdAt;
    private BuildingListingOutboundDTO buildingListing;
    private LandListingOutboundDTO landListing;

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SellerType getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerType sellerType) {
        this.sellerType = sellerType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNameUri() {
        return nameUri;
    }

    public void setNameUri(String nameUri) {
        this.nameUri = nameUri;
    }

    public ListingSubTypeSummaryDTO getListingSubType() {
        return listingSubType;
    }

    public void setListingSubType(ListingSubTypeSummaryDTO listingSubType) {
        this.listingSubType = listingSubType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BuildingListingOutboundDTO getBuildingListing() {
        return buildingListing;
    }

    public void setBuildingListing(BuildingListingOutboundDTO buildingListing) {
        this.buildingListing = buildingListing;
    }

    public LandListingOutboundDTO getLandListing() {
        return landListing;
    }

    public void setLandListing(LandListingOutboundDTO landListing) {
        this.landListing = landListing;
    }
}
