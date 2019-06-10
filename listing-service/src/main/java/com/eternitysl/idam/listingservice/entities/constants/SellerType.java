package com.eternitysl.idam.listingservice.entities.constants;

public enum SellerType {
    OWNER("owner"),
    AGENT("agent");

    private String value;

    private SellerType(String value){
        this.value = value;
    }

    public static SellerType fromValue(String value){
        for(SellerType sellerType: values()){
            if(sellerType.value.equalsIgnoreCase(value)){
                return sellerType;
            }
        }

        throw new IllegalArgumentException("Unknown enum seller type "+value);
    }
}
