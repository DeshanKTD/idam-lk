package com.eternitysl.idam.common.units.entities;

public enum UnitType {
    TIME("time"),
    LENGTH("length"),
    AREA("area");

    private String value;

    private UnitType(String value){
        this.value = value;
    }

    public static UnitType fromValue(String value){
        for(UnitType unit: values()){
            if(unit.value.equalsIgnoreCase(value)){
                return unit;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum unit type "+value);
    }


}
