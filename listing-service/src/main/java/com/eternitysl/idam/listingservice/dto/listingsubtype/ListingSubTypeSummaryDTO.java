package com.eternitysl.idam.listingservice.dto.listingsubtype;

import com.eternitysl.idam.listingservice.dto.listingtype.ListingTypeSummaryDTO;
import com.eternitysl.idam.listingservice.entities.ListingSubType;

import java.util.ArrayList;
import java.util.List;

public class ListingSubTypeSummaryDTO {
    private int id;
    private String name;
    private ListingTypeSummaryDTO mainType;
    private String localName;

    public ListingSubTypeSummaryDTO() {
    }

    public static ListingSubTypeSummaryDTO populate(ListingSubType listingSubType) {
        ListingSubTypeSummaryDTO listingSubTypeSummaryDTO = new ListingSubTypeSummaryDTO();

        ListingTypeSummaryDTO listingTypeSummaryDTO = ListingTypeSummaryDTO.populate(listingSubType.getMainType());
        listingSubTypeSummaryDTO.id = listingSubType.getId();
        listingSubTypeSummaryDTO.name = listingSubType.getName();
        listingSubTypeSummaryDTO.mainType = listingTypeSummaryDTO;
        listingSubTypeSummaryDTO.localName = listingSubType.getLocalName();

        return listingSubTypeSummaryDTO;
    }

    public static List<ListingSubTypeSummaryDTO> populate(List<ListingSubType> list) {
        List<ListingSubTypeSummaryDTO> listingSubTypeSummaryDTOS = new ArrayList<>();

        for (ListingSubType listingSubType : list) {
            ListingSubTypeSummaryDTO listingSubTypeSummaryDTO = populate(listingSubType);
            listingSubTypeSummaryDTOS.add(listingSubTypeSummaryDTO);
        }

        return listingSubTypeSummaryDTOS;
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

    public ListingTypeSummaryDTO getMainType() {
        return mainType;
    }
}
