package com.eternitysl.idam.listingservice.dto.listingsubtype;

import com.eternitysl.idam.listingservice.entities.ListingSubType;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class ListingSubTypeUpdateDTO {

    @ApiModelProperty(hidden = true)
    private int id;

    private String name;
    private String mainType;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private ListingTypeService listingTypeService;

    public ListingSubTypeUpdateDTO() {

    }

    public ListingSubType convert() {
        ListingSubType listingSubType = new ListingSubType();
        listingSubType.setName(this.name.replace(" ","_").toLowerCase());
        listingSubType.setLocalName(this.name);
        listingSubType.setMainType(listingTypeService.getListingType(this.mainType));
        return listingSubType;
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
