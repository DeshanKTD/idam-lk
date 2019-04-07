package com.eternitysl.idam.listingservice.dto;

import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class PriceRateDTO {
    private int id;
    private  String name;
    private  String mainType;

    @Autowired
    ListingTypeService listingTypeService;

    public PriceRateDTO() {
    }

    public PriceRate convert(){
        PriceRate priceRate = new PriceRate();
        priceRate.setName(this.name);
        priceRate.setMainType(listingTypeService.getListingType(this.mainType));

        return priceRate;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }
}
