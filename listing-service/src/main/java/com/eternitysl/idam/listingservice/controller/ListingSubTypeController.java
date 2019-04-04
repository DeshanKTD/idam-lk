package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.entities.ListingSubType;
import com.eternitysl.idam.listingservice.services.ListingSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("listing-type/sub")
public class ListingSubTypeController {

    @Autowired
    ListingSubTypeService listingSubTypeService;

    @GetMapping
    public List<ListingSubType> getAll(){
        return listingSubTypeService.getAll();
    }

    @PostMapping
    public ListingSubType createListingSubType(@Valid @RequestBody ListingSubType listingSubType){
        return listingSubTypeService.create(listingSubType);
    }



}

