package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.ListingTypeDTO;
import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/listing-type/main")
public class ListingTypeController {

    @Autowired
    ListingTypeService listingTypeService;

    @GetMapping
    public List<ListingType> getAllListingTypes() {
        return listingTypeService.getAll();
    }

    @GetMapping("/{id}")
    public ListingType getListingTypeById(@PathVariable(value = "id") String id){
        return listingTypeService.getListingType(id);
    }

    @PostMapping
    public ListingType createListingType(@Valid @RequestBody ListingTypeDTO listingTypeDTO) {
        return listingTypeService.create(listingTypeDTO.convert());
    }

    @PutMapping("/{id}")
    public ListingType updateListingType(@PathVariable(value = "id") String id,
                                         @Valid @RequestBody ListingTypeDTO listingTypeDTO) {
        return listingTypeService.update(id, listingTypeDTO.convert());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListingType(@PathVariable(value = "id") String id) {
        if (listingTypeService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
