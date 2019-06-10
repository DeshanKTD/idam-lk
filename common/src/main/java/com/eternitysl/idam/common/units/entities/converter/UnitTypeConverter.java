package com.eternitysl.idam.common.units.entities.converter;

import com.eternitysl.idam.common.units.entities.UnitType;

import java.beans.PropertyEditorSupport;

public class UnitTypeConverter extends PropertyEditorSupport {
    public void setAsText(final String text) throws IllegalArgumentException{
        setValue(UnitType.fromValue(text));
    }
}
