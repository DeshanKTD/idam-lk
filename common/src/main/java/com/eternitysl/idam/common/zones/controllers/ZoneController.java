package com.eternitysl.idam.common.zones.controllers;

import com.eternitysl.idam.common.zones.dtos.InboundDistrictDTO;
import com.eternitysl.idam.common.zones.dtos.InboundTownDTO;
import com.eternitysl.idam.common.zones.dtos.OutboundDistrictDTO;
import com.eternitysl.idam.common.zones.dtos.OutboundTownDTO;
import com.eternitysl.idam.common.zones.entities.District;
import com.eternitysl.idam.common.zones.entities.Town;
import com.eternitysl.idam.common.zones.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping("/district")
    public List<OutboundDistrictDTO> getAllDistricts(){
        return OutboundDistrictDTO.populate(zoneService.getAllDistricts());
    }

    @GetMapping("/district/{id}")
    public OutboundDistrictDTO getSingleDistrict(@PathVariable(value = "id")String id){
        return OutboundDistrictDTO.populate(zoneService.getSingleDistrict(id));
    }

    @PostMapping("/district")
    public OutboundDistrictDTO createDistrict(@Valid @RequestBody InboundDistrictDTO inboundDistrictDTO){
        District district = zoneService.createDistrict(inboundDistrictDTO.convert());
        return OutboundDistrictDTO.populate(district);
    }

    @PutMapping("/district/{id}")
    public OutboundDistrictDTO updateDistrict(@PathVariable(value = "id") String id,
                                              @Valid @RequestBody InboundDistrictDTO inboundDistrictDTO){
        District district = zoneService.updateDistrict(id,inboundDistrictDTO.convert());
        return OutboundDistrictDTO.populate(district);
    }

    @DeleteMapping("/district/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable(value = "id") String id){
        if(zoneService.deleteDistrict(id)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }



    @GetMapping("/town")
    public List<OutboundTownDTO> getALlTowns(){
        return OutboundTownDTO.populate(zoneService.getAllTowns());
    }

    @GetMapping("/town/{id}")
    public OutboundTownDTO getSingleTown(@PathVariable(value = "id")String id){
        return OutboundTownDTO.populate(zoneService.getSingleTown(id));
    }

    @PostMapping("/town")
    public OutboundTownDTO createTown(@Valid @RequestBody InboundTownDTO inboundTownDTO){
        inboundTownDTO.setZoneService(zoneService);
        Town town = zoneService.createTown(inboundTownDTO.convert());
        return OutboundTownDTO.populate(town);
    }

    @PutMapping("/town/{id}")
    public OutboundTownDTO updateTown(@PathVariable(value = "id") String id,
                                              @Valid @RequestBody InboundTownDTO inboundTownDTO){
        inboundTownDTO.setZoneService(zoneService);
        Town town = zoneService.updateTown(id,inboundTownDTO.convert());
        return OutboundTownDTO.populate(town);
    }

    @DeleteMapping("/town/{id}")
    public ResponseEntity<?> deleteTown(@PathVariable(value = "id") String id){
        if(zoneService.deleteTown(id)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }



}
