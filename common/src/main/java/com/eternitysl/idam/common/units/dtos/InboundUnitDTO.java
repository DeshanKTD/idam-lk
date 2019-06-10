package com.eternitysl.idam.common.units.dtos;

import com.eternitysl.idam.common.units.entities.Unit;
import com.eternitysl.idam.common.units.entities.UnitType;

public class InboundUnitDTO {
    private String unitName;
    private String unitType;
    private String unit;

    public Unit convert(){
        Unit unit = new Unit();
        unit.setName(this.unitName);
        unit.setUnit(this.unit);
        unit.setUnitType(UnitType.fromValue(this.unitType));

        return unit;
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
