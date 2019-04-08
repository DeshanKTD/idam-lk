package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.ListingSubTypeDTO;
import com.eternitysl.idam.listingservice.entities.ListingSubType;
import com.eternitysl.idam.listingservice.services.ListingSubTypeService;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("listing-type/sub")
public class ListingSubTypeController {

    @Autowired
    private ListingSubTypeService listingSubTypeService;

    @Autowired
    private ListingTypeService listingTypeService;

    @GetMapping
    public List<ListingSubType> getAll() {
        return listingSubTypeService.getAll();
    }

    @PostMapping
    public ListingSubType createListingSubType(@Valid @RequestBody ListingSubTypeDTO listingSubTypeDTO) {
        listingSubTypeDTO.setListingTypeService(this.listingTypeService);
        return listingSubTypeService.create(listingSubTypeDTO.convert());
    }

    @PutMapping("/{id}")
    public ListingSubType updateListingSubType(@PathVariable(value = "id") String id,
                                               @Valid @RequestBody ListingSubTypeDTO listingSubTypeDTO) {
        listingSubTypeDTO.setListingTypeService(this.listingTypeService);
        return listingSubTypeService.update(id, listingSubTypeDTO.convert());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListingType(@PathVariable(value = "id") String id) {
        if (listingSubTypeService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}

