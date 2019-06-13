package com.eternitysl.idam.listingservice.dto.listing.land;

import com.eternitysl.idam.listingservice.dto.availability.AvailabilitySummaryDTO;
import com.eternitysl.idam.listingservice.dto.pricerate.PriceRateSummaryDTO;
import com.eternitysl.idam.listingservice.entities.listings.landlisting.LandSellingType;

public class LandListingOutboundDTO {
    private double landArea;
    private String landAreaUnit;
    private PriceRateSummaryDTO priceRate;
    private AvailabilitySummaryDTO availability;
    private LandSellingType landSellingType;


    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public String getLandAreaUnit() {
        return landAreaUnit;
    }

    public void setLandAreaUnit(String landAreaUnit) {
        this.landAreaUnit = landAreaUnit;
    }

    public PriceRateSummaryDTO getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(PriceRateSummaryDTO priceRate) {
        this.priceRate = priceRate;
    }

    public AvailabilitySummaryDTO getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilitySummaryDTO availability) {
        this.availability = availability;
    }

    public LandSellingType getLandSellingType() {
        return landSellingType;
    }

    public void setLandSellingType(LandSellingType landSellingType) {
        this.landSellingType = landSellingType;
    }
}
