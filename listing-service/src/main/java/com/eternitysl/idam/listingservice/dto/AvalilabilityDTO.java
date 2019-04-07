package com.eternitysl.idam.listingservice.dto;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class AvalilabilityDTO {
    private String name;
    private String mainType;

    @Autowired
    ListingTypeService listingTypeService;

    public AvalilabilityDTO() {
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
