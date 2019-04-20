package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.pricerate.PriceRateSummaryDTO;
import com.eternitysl.idam.listingservice.dto.pricerate.PriceRateUpdateDTO;
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
    public List<PriceRateSummaryDTO> getAll() {
        List<PriceRate> priceRates = priceRateService.getAll();
        return PriceRateSummaryDTO.populate(priceRates);
    }

    @GetMapping("/{id}")
    public PriceRateSummaryDTO getSelected(@PathVariable(value = "id") String id) {
        PriceRate priceRate = priceRateService.getPriceRate(id);
        return PriceRateSummaryDTO.populate(priceRate);
    }

    @PostMapping
    public PriceRateSummaryDTO createPriceRate(@Valid @RequestBody PriceRateUpdateDTO priceRateUpdateDTO) {
        priceRateUpdateDTO.setListingTypeService(listingTypeService);
        PriceRate priceRate = priceRateService.create(priceRateUpdateDTO.convert());

        return PriceRateSummaryDTO.populate(priceRate);
    }

    @PutMapping("/{id}")
    public PriceRateSummaryDTO updatePriceRate(@PathVariable(value = "id") String id,
                                               @Valid @RequestBody PriceRateUpdateDTO priceRateUpdateDTO) {
        priceRateUpdateDTO.setListingTypeService(listingTypeService);
        PriceRate priceRate = priceRateService.update(id, priceRateUpdateDTO.convert());

        return PriceRateSummaryDTO.populate(priceRate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePriceRate(@PathVariable(value = "id") String id) {
        if (priceRateService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
