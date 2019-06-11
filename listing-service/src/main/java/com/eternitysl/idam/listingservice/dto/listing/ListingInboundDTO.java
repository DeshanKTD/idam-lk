package com.eternitysl.idam.listingservice.dto.listing;

import com.eternitysl.idam.listingservice.dto.listing.building.BuildingListingInboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.land.LandListingInboundDTO;

public class ListingInboundDTO {
    private String addedBy;
    private String title;
    private String description;
    private String sellerType;
    private String contactName;
    private String contactNumber;
    private String listingSubType;
    private String nameUri;
    private String orderAt;
    private int price;
    private LandListingInboundDTO landListing;
    private BuildingListingInboundDTO buildingListing;


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

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getListingSubType() {
        return listingSubType;
    }

    public void setListingSubType(String listingSubType) {
        this.listingSubType = listingSubType;
    }

    public String getNameUri() {
        return nameUri;
    }

    public void setNameUri(String nameUri) {
        this.nameUri = nameUri;
    }

    public String getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(String orderAt) {
        this.orderAt = orderAt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LandListingInboundDTO getLandListing() {
        return landListing;
    }

    public void setLandListing(LandListingInboundDTO landListing) {
        this.landListing = landListing;
    }

    public BuildingListingInboundDTO getBuildingListing() {
        return buildingListing;
    }

    public void setBuildingListing(BuildingListingInboundDTO buildingListing) {
        this.buildingListing = buildingListing;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
