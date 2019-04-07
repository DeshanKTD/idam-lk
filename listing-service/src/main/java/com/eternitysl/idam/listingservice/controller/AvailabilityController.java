package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.AvalilabilityDTO;
import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping
    public List<Availability> getAll() {
        return availabilityService.getAll();
    }

    @PostMapping
    public Availability createListingSubType(@Valid @RequestBody AvalilabilityDTO avalilabilityDTO) {
        return availabilityService.create(avalilabilityDTO.convert());
    }

    @PutMapping("/{id}")
    public Availability updateListingSubType(@PathVariable(value = "id") String id,
                                             @Valid @RequestBody AvalilabilityDTO avalilabilityDTO) {
        return availabilityService.update(id, avalilabilityDTO.convert());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListingType(@PathVariable(value = "id") String id) {
        if (availabilityService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
