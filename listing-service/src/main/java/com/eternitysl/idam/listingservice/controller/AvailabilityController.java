package com.eternitysl.idam.listingservice.controller;

import com.eternitysl.idam.listingservice.dto.availability.AvailabilitySummaryDTO;
import com.eternitysl.idam.listingservice.dto.availability.AvailabilityUpdateDTO;
import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.services.AvailabilityService;
import com.eternitysl.idam.listingservice.services.ListingTypeService;
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

    @Autowired
    private ListingTypeService listingTypeService;

    @GetMapping
    public List<AvailabilitySummaryDTO> getAll() {
        List<Availability> availabilities = availabilityService.getAll();
        return AvailabilitySummaryDTO.populate(availabilities);
    }

    @GetMapping("/{id}")
    public AvailabilitySummaryDTO getSelected(@PathVariable(value = "id") String id){
        Availability availability = availabilityService.getAvailabilityType(id);
        return AvailabilitySummaryDTO.populate(availability);
    }

    @PostMapping
    public AvailabilitySummaryDTO createListingSubType(@Valid @RequestBody AvailabilityUpdateDTO availabilityUpdateDTO) {
        availabilityUpdateDTO.setListingTypeService(listingTypeService);
        Availability availability = availabilityService.create(availabilityUpdateDTO.convert());

        return AvailabilitySummaryDTO.populate(availability);
    }

    @PutMapping("/{id}")
    public AvailabilitySummaryDTO updateListingSubType(@PathVariable(value = "id") String id,
                                             @Valid @RequestBody AvailabilityUpdateDTO availabilityUpdateDTO) {
        availabilityUpdateDTO.setListingTypeService(listingTypeService);
        Availability availability = availabilityService.update(id, availabilityUpdateDTO.convert());

        return AvailabilitySummaryDTO.populate(availability);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListingType(@PathVariable(value = "id") String id) {
        if (availabilityService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
