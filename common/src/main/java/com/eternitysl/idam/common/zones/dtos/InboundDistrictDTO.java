package com.eternitysl.idam.common.zones.dtos;

import com.eternitysl.idam.common.zones.entities.District;

public class InboundDistrictDTO {
    private String name;

    public District convert(){
        District district = new District();
        district.setName(this.name);
        return district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
