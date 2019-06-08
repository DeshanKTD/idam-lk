package com.eternitysl.idam.common.zones.dtos;

import com.eternitysl.idam.common.zones.entities.District;
import com.eternitysl.idam.common.zones.entities.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OutboundDistrictDTO {

    private String name;
    private Set<Town> townList;

    public static OutboundDistrictDTO populate(District district) {
        OutboundDistrictDTO outBoundDistrictDTO = new OutboundDistrictDTO();
        outBoundDistrictDTO.setName(district.getName());
        outBoundDistrictDTO.setTownList(district.getTowns());

        return outBoundDistrictDTO;
    }

    public static List<OutboundDistrictDTO> populate(List<District> districts){
        List<OutboundDistrictDTO> outboundDistrictDTOS = new ArrayList<>();

        for(District district: districts){
            OutboundDistrictDTO outBoundDistrictDTO = populate(district);
            outboundDistrictDTOS.add(outBoundDistrictDTO);
        }

        return outboundDistrictDTOS;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Town> getTownList() {
        return townList;
    }

    public void setTownList(Set<Town> townList) {
        this.townList = townList;
    }
}
