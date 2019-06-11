package com.eternitysl.idam.listingservice.dto.listing.building;

public class BuildingRentalInboundDTO {
    private int minimumTerm;
    private String minTermUnit;
    private boolean billsIncluded;
    private int depositCount;
    private String depositUnit;

    public int getMinimumTerm() {
        return minimumTerm;
    }

    public void setMinimumTerm(int minimumTerm) {
        this.minimumTerm = minimumTerm;
    }

    public String getMinTermUnit() {
        return minTermUnit;
    }

    public void setMinTermUnit(String minTermUnit) {
        this.minTermUnit = minTermUnit;
    }

    public boolean isBillsIncluded() {
        return billsIncluded;
    }

    public void setBillsIncluded(boolean billsIncluded) {
        this.billsIncluded = billsIncluded;
    }

    public int getDepositCount() {
        return depositCount;
    }

    public void setDepositCount(int depositCount) {
        this.depositCount = depositCount;
    }

    public String getDepositUnit() {
        return depositUnit;
    }

    public void setDepositUnit(String depositUnit) {
        this.depositUnit = depositUnit;
    }
}
