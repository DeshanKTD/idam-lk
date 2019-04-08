package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.PriceRateDTO;
import com.eternitysl.idam.listingservice.entities.ListingType;
import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
import com.eternitysl.idam.listingservice.services.PriceRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/price-rate")
public class PriceRateController {

    @Autowired
    private PriceRateService priceRateService;

    @Autowired
    private ListingTypeService listingTypeService;

    @GetMapping
    public List<PriceRate> getAll() {
        return priceRateService.getAll();
    }

    @PostMapping
    public PriceRate createListingSubType(@Valid @RequestBody PriceRateDTO priceRateDTO) {
        priceRateDTO.setListingTypeService(listingTypeService);
        return priceRateService.create(priceRateDTO.convert());
    }

    @PutMapping("/{id}")
    public PriceRate updateListingSubType(@PathVariable(value = "id") String id,
                                          @Valid @RequestBody PriceRateDTO priceRateDTO) {
        priceRateDTO.setListingTypeService(listingTypeService);
        return priceRateService.update(id, priceRateDTO.convert());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListingType(@PathVariable(value = "id") String id) {
        if (priceRateService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
