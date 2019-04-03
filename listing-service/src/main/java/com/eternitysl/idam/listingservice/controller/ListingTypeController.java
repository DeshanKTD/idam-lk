package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.repositories.ListingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/listing-type")
public class ListingTypeController {

    @Autowired
    ListingTypeRepository listingTypeRepository;

    @GetMapping("/")
    public List<ListingType> getAllListingTypes() {
        return listingTypeRepository.findAll();
    }

    @PostMapping("/")
    public ListingType createListingType(@Valid @RequestBody ListingType listingType){
        return listingTypeRepository.save(listingType);
    }
}
