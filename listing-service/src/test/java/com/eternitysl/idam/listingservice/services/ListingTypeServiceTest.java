package com.eternitysl.idam.listingservice.services;

import com.eternitysl.idam.listingservice.entities.ListingType;
import org.hibernate.type.ListType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListingTypeServiceTest {

    @Autowired
    private ListingTypeService listingTypeService;

    @Before
    public void before(){
        ListingType listingType = new ListingType();
        listingType.setName("building");
        listingTypeService.create(listingType);

    }

    @After
    public void after(){
        List<ListingType> listingTypes = listingTypeService.getAll();
        if(listingTypes.size()>1){
            listingTypeService.delete("land");
            listingTypeService.delete("building");
        }
        else if(listingTypes.size()==0){
            return;
        }
        else if(listingTypes.get(0).getName().equals("building")){
            listingTypeService.delete("building");
        }else {
            listingTypeService.delete("newbuilding");
        }
    }

    @Test
    public void getAll() {
        List<ListingType> listingTypes = listingTypeService.getAll();
        boolean expected = false;
        if(listingTypes.size()==1 && listingTypes.get(0).getName().equals("building")){
            expected = true;
        }
        assertTrue(expected);
    }

    @Test
    public void getListingType() {
        ListingType listingType = listingTypeService.getListingType("building");
        assertEquals("building",listingType.getName());
    }

    @Test
    public void create() {
        ListingType listingType = new ListingType();
        listingType.setName("land");
        listingTypeService.create(listingType);
        ListingType qListingType = listingTypeService.getListingType("land");
        assertEquals("land",qListingType.getName());
    }

    @Test
    public void update() {
        ListingType listingType = new ListingType();
        listingType.setName("newbuilding");
        listingTypeService.update("building",listingType);
        ListingType qListingType = listingTypeService.getListingType("newbuilding");
        assertEquals("newbuilding",qListingType.getName());


    }

    @Test
    public void delete() {
        listingTypeService.delete("building");
        assertTrue(listingTypeService.getAll().size()==0);

    }
}