package com.eternitysl.idam.common.units.controllers;

import com.eternitysl.idam.common.units.dtos.InboundUnitDTO;
import com.eternitysl.idam.common.units.dtos.OutboundUnitDTO;
import com.eternitysl.idam.common.units.entities.Unit;
import com.eternitysl.idam.common.units.entities.UnitType;
import com.eternitysl.idam.common.units.entities.converter.UnitTypeConverter;
import com.eternitysl.idam.common.units.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<OutboundUnitDTO> getAllUnits() {
        return OutboundUnitDTO.populate(unitService.getAllUnits());
    }

    @GetMapping("/type/{unitType}")
    public List<OutboundUnitDTO> getUnitsByType(@PathVariable(value = "unitType") UnitType unitType) {
        return OutboundUnitDTO.populate(unitService.getUnitByType(unitType));
    }

    @GetMapping("/type")
    public List<String> getAllUnitTypes(){
        return unitService.getAllUnitTypes();
    }

    @PostMapping
    public OutboundUnitDTO createUnit(@Valid @RequestBody InboundUnitDTO inboundUnitDTO) {
        Unit unit = unitService.createUnit(inboundUnitDTO.convert());
        return OutboundUnitDTO.populate(unit);
    }

    @PutMapping("/{id}")
    public OutboundUnitDTO updateUnit(@PathVariable(value = "id") String id,
                                      @Valid @RequestBody InboundUnitDTO inboundUnitDTO) {
        Unit unit = unitService.updateAdUnit(id, inboundUnitDTO.convert());
        return OutboundUnitDTO.populate(unit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable(value = "id") String id) {
        if (unitService.deleteUnit(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @InitBinder
    public void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(UnitType.class, new UnitTypeConverter());
    }
}

