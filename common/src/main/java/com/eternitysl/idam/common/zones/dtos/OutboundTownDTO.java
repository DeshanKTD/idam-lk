package com.eternitysl.idam.common.zones.dtos;

import com.eternitysl.idam.common.zones.entities.District;
import com.eternitysl.idam.common.zones.entities.Town;

import java.util.ArrayList;
import java.util.List;

public class OutboundTownDTO {

    private String name;
    private District district;

    public static OutboundTownDTO populate(Town town){
        OutboundTownDTO outboundTownDTO = new OutboundTownDTO();
        outboundTownDTO.setName(town.getName());
        outboundTownDTO.setDistrict(town.getDistrict());

        return outboundTownDTO;
    }

    public static List<OutboundTownDTO> populate(List<Town> towns){
        List<OutboundTownDTO> outboundTownDTOS = new ArrayList<>();
        for(Town town: towns){
            OutboundTownDTO outboundTownDTO = populate(town);
            outboundTownDTOS.add(outboundTownDTO);
        }

        return outboundTownDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
