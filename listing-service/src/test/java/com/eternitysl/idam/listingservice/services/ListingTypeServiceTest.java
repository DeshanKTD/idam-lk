package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.ListingType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListingTypeServiceTest {
    private ListingTypeService listingTypeService;

    @Before
    public void before(){
        listingTypeService = new ListingTypeService();
    }


    @Test
    public void getAll() {
    }

    @Test
    public void getListingType() {
    }

    @Test
    public void create() {
        ListingType listingType = new ListingType();
        listingType.setName("building");
        listingTypeService.create(listingType);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}