package com.eternitysl.idam.listingservice.entities.deserializers;

import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ListingTypeDeserializer extends StdDeserializer<ListingType> {
    @Autowired
    ListingTypeService listingTypeService;

    public ListingTypeDeserializer(Class<?> vc) {
        super(vc);
    }

    public ListingTypeDeserializer(){
        this(null);
    }

    @Override
    public ListingType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException{
        String stringId = jsonParser.getText();
        try {
            return listingTypeService.getListingType(stringId);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
