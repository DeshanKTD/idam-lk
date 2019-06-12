package com.eternitysl.idam.listingservice.dto.listingtype;

import com.eternitysl.idam.listingservice.entities.ListingType;

import java.util.ArrayList;
import java.util.List;

public class ListingTypeSummaryDTO {
    private int id;
    private String name;
    private String localName;

    public ListingTypeSummaryDTO() {

    }

    public static ListingTypeSummaryDTO populate(ListingType listingType) {
        ListingTypeSummaryDTO listingTypeSummaryDTO = new ListingTypeSummaryDTO();
        listingTypeSummaryDTO.id = listingType.getId();
        listingTypeSummaryDTO.localName = listingType.getLocalName();
        listingTypeSummaryDTO.name = listingType.getName();
        return listingTypeSummaryDTO;
    }

    public static List<ListingTypeSummaryDTO> populate(List<ListingType> list) {
        List<ListingTypeSummaryDTO> listingTypeSummaryDTOS = new ArrayList<>();
        for (ListingType listingType : list) {
            listingTypeSummaryDTOS.add(populate(listingType));
        }

        return listingTypeSummaryDTOS;
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

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
