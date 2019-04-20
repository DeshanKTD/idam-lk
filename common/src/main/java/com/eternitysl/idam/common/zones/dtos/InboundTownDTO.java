package com.eternitysl.idam.common.zones.dtos;

import com.eternitysl.idam.common.zones.entities.Town;
import com.eternitysl.idam.common.zones.services.ZoneService;

public class InboundTownDTO {

    private String name;
    private String district;
    private ZoneService zoneService;

    public Town convert(){
        Town town = new Town();
        town.setName(this.name);
        town.setDistrict(zoneService.getSingleDistrict(this.district));
        return town;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
