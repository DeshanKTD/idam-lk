package com.eternitysl.idam.listingservice.dto;

import com.eternitysl.idam.listingservice.entities.ListingType;
import io.swagger.annotations.ApiModelProperty;

public class ListingTypeDTO {

    @ApiModelProperty(hidden = true)
    private int id;

    private String name;

    public ListingTypeDTO() {
    }

    public ListingType convert(){
        ListingType listingType = new ListingType();
        listingType.setName(this.name);
        return listingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
