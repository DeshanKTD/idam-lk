package com.eternitysl.idam.listingservice.entities.listings.buildinglisting;

public enum BuildingSellingType {
    SELL("sell"),
    RENT("rent");

    private String value;

    private BuildingSellingType(String value){
        this.value = value;
    }

    private static BuildingSellingType fromValue(String value){
        for(BuildingSellingType buildingSellingType: values()){
            if(buildingSellingType.value.equalsIgnoreCase(value)){
                return buildingSellingType;
            }
        }

        throw new IllegalArgumentException("Unknown enum BuildingSellingType :"+ value);
    }
}
