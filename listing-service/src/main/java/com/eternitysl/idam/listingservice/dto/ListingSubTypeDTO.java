package com.eternitysl.idam.listingservice.dto;

import com.eternitysl.idam.listingservice.entities.ListingSubType;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class ListingSubTypeDTO {

    private int id;
    private String name;
    private String mainType;

    @Autowired
    private ListingTypeService listingTypeService;

    public ListingSubTypeDTO() {
    }

    public ListingSubType convert(){
        ListingSubType listingSubType = new ListingSubType();
        listingSubType.setName(this.name);
        listingSubType.setMainType(listingTypeService.getListingType(this.mainType));
        return listingSubType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
