package com.eternitysl.idam.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceDuplicateException extends RuntimeException {
    private String resouceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceDuplicateException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s is duplicated with %s : %s", resourceName, fieldName, fieldValue));
        this.resouceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResouceName() {
        return resouceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
