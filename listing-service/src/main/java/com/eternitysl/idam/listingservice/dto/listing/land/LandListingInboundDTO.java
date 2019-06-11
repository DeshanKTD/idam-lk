package com.eternitysl.idam.listingservice.dto.listing.land;

public class LandListingInboundDTO {
    private double landArea;

    private String landAreaUnit;

    private String priceRate;

    private String availability;

    private String landSellingType;

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

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getLandSellingType() {
        return landSellingType;
    }

    public void setLandSellingType(String landSellingType) {
        this.landSellingType = landSellingType;
    }
}
