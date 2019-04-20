package com.eternitysl.idam.listingservice.dto.pricerate;

import com.eternitysl.idam.listingservice.dto.listingtype.ListingTypeSummaryDTO;
import com.eternitysl.idam.listingservice.entities.PriceRate;

import java.util.ArrayList;
import java.util.List;

public class PriceRateSummaryDTO {
    private int id;
    private String name;
    private String localName;
    private ListingTypeSummaryDTO mainType;


    public PriceRateSummaryDTO() {
    }

    public static PriceRateSummaryDTO populate(PriceRate priceRate) {
        PriceRateSummaryDTO priceRateSummaryDTO = new PriceRateSummaryDTO();

        ListingTypeSummaryDTO listingTypeSummaryDTO = new ListingTypeSummaryDTO();
        listingTypeSummaryDTO.populate(priceRate.getMainType());

        priceRateSummaryDTO.id = priceRate.getId();
        priceRateSummaryDTO.name = priceRate.getName();

        return priceRateSummaryDTO;
    }

    public static List<PriceRateSummaryDTO> populate(List<PriceRate> priceRateList) {
        List<PriceRateSummaryDTO> priceRateSummaryDTOS = new ArrayList<>();

        for (PriceRate priceRate : priceRateList) {
            PriceRateSummaryDTO priceRateSummaryDTO = populate(priceRate);
            priceRateSummaryDTOS.add(priceRateSummaryDTO);
        }

        return priceRateSummaryDTOS;
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

    public void setMainType(ListingTypeSummaryDTO mainType) {
        this.mainType = mainType;
    }
}
