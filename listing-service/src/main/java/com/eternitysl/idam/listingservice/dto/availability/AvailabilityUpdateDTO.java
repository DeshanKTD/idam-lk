package com.eternitysl.idam.listingservice.dto.availability;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityUpdateDTO {

    @Autowired
    ListingTypeService listingTypeService;
    @ApiModelProperty(hidden = true)
    private int id;
    private String name;
    private String mainType;

    public AvailabilityUpdateDTO() {
    }

    public Availability convert() {
        Availability availability = new Availability();
        availability.setName(this.name.replace(" ","_").toLowerCase());
        availability.setMainType(listingTypeService.getListingType(this.mainType));
        availability.setLocalName(this.name);

        return availability;
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
