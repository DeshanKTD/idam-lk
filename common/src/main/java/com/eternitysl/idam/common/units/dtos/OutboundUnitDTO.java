package com.eternitysl.idam.common.units.dtos;

import com.eternitysl.idam.common.units.entities.Unit;

import java.util.ArrayList;
import java.util.List;

public class OutboundUnitDTO {
    private String unitName;
    private String unitType;
    private String unit;

    public static OutboundUnitDTO populate(Unit unit){
        OutboundUnitDTO outboundUnitDTO = new OutboundUnitDTO();
        outboundUnitDTO.setUnit(unit.getUnit());
        outboundUnitDTO.setUnitName(unit.getName());
        outboundUnitDTO.setUnitType(unit.getUnitType().name());
        return outboundUnitDTO;
    }

    public static List<OutboundUnitDTO> populate(List<Unit> units){
        List<OutboundUnitDTO> outboundUnitDTOS = new ArrayList<>();
        for(Unit unit:units){
            OutboundUnitDTO outboundUnitDTO = populate(unit);
            outboundUnitDTOS.add(outboundUnitDTO);
        }
        return outboundUnitDTOS;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
