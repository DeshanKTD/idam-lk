package com.eternitysl.idam.listingservice.dto.pricerate;

import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

public class PriceRateUpdateDTO {

    @Autowired
    private ListingTypeService listingTypeService;
    @ApiModelProperty(hidden = true)
    private int id;
    private String name;
    private String mainType;


    public PriceRateUpdateDTO() {
    }

    public PriceRate convert() {
        PriceRate priceRate = new PriceRate();
        priceRate.setName(this.name.replace(" ","_").toLowerCase());
        priceRate.setLocalName(this.name);
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

    @JsonIgnore
    public void setListingTypeService(ListingTypeService listingTypeService) {
        this.listingTypeService = listingTypeService;
    }


}
