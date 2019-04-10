package com.eternitysl.idam.listingservice.dto.availability;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityUpdateDTO {

    @ApiModelProperty(hidden = true)
    private int id;

    private String name;
    private String mainType;

    @Autowired
    ListingTypeService listingTypeService;

    public AvailabilityUpdateDTO() {
    }

    public Availability convert(){
        Availability availability = new Availability();
        availability.setName(this.name);
        availability.setMainType(listingTypeService.getListingType(this.mainType));

        return availability;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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
