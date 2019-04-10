package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.listingtype.ListingTypeSummaryDTO;
import com.eternitysl.idam.listingservice.dto.listingtype.ListingTypeUpdateDTO;
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
    public List<ListingTypeSummaryDTO> getAllListingTypes() {
        List<ListingType> listingTypes = listingTypeService.getAll();
        return ListingTypeSummaryDTO.populate(listingTypes);
    }


    @GetMapping("/{id}")
    public ListingTypeSummaryDTO getListingTypeById(@PathVariable(value = "id") String id) {
        ListingType listingType = listingTypeService.getListingType(id);
        return ListingTypeSummaryDTO.populate(listingType);
    }

    @PostMapping
    public ListingTypeSummaryDTO createListingType(@Valid @RequestBody ListingTypeUpdateDTO listingTypeUpdateDTO) {
        ListingType listingType = listingTypeService.create(listingTypeUpdateDTO.convert());
        return ListingTypeSummaryDTO.populate(listingType);
    }

    @PutMapping("/{id}")
    public ListingTypeSummaryDTO updateListingType(@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody ListingTypeUpdateDTO listingTypeUpdateDTO) {
        ListingType listingType = listingTypeService.update(id, listingTypeUpdateDTO.convert());
        return ListingTypeSummaryDTO.populate(listingType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListingType(@PathVariable(value = "id") String id) {
        if (listingTypeService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
