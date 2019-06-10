package com.eternitysl.idam.listingservice.entities.listings.landlisting;

public enum LandSellingType {
    SELL("sell"),
    LEASE("lease"),
    EITHER("either");

    private String value;

    private LandSellingType(String value){
        this.value = value;
    }

    public static LandSellingType fromValue(String value){
        for(LandSellingType landSellingType: values()){
            if(landSellingType.value.equalsIgnoreCase(value)){
                return landSellingType;
            }
        }

        throw new IllegalArgumentException("Unknown enum LandSellingType :"+ value);
    }
}
