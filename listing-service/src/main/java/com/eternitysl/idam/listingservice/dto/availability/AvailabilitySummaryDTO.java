package com.eternitysl.idam.listingservice.dto.availability;

import com.eternitysl.idam.listingservice.dto.listingtype.ListingTypeSummaryDTO;
import com.eternitysl.idam.listingservice.entities.Availability;

import java.util.ArrayList;
import java.util.List;

public class AvailabilitySummaryDTO {
    private int id;
    private String name;
    private ListingTypeSummaryDTO mainType;
    private String localName;

    public AvailabilitySummaryDTO() {
    }

    public static AvailabilitySummaryDTO populate(Availability availability) {
        AvailabilitySummaryDTO availabilitySummaryDTO = new AvailabilitySummaryDTO();

        ListingTypeSummaryDTO listingTypeSummaryDTO = new ListingTypeSummaryDTO();
        listingTypeSummaryDTO.populate(availability.getMainType());

        availabilitySummaryDTO.id = availability.getId();
        availabilitySummaryDTO.name = availability.getName();

        return availabilitySummaryDTO;
    }

    public static List<AvailabilitySummaryDTO> populate(List<Availability> availabilities) {
        List<AvailabilitySummaryDTO> availabilitySummaryDTOS = new ArrayList<>();

        for (Availability availability : availabilities) {
            AvailabilitySummaryDTO availabilitySummaryDTO = populate(availability);
            availabilitySummaryDTOS.add(availabilitySummaryDTO);
        }
        return availabilitySummaryDTOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListingTypeSummaryDTO getMainType() {
        return mainType;
    }

    public void setMainType(ListingTypeSummaryDTO mainType) {
        this.mainType = mainType;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
