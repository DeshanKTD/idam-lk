package com.eternitysl.idam.listingservice.entities;

import com.eternitysl.idam.listingservice.entities.listings.LandListing;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "price_rates")
public class PriceRate {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "main_type", nullable = false)
    private ListingType mainType;

    @OneToMany(mappedBy = "priceRate",fetch = FetchType.LAZY)
    private Set<LandListing> landListings;

    public PriceRate() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListingType getMainType() {
        return mainType;
    }

    public void setMainType(ListingType mainType) {
        this.mainType = mainType;
    }
}
