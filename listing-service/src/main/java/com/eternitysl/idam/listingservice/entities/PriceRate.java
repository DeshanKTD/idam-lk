package com.eternitysl.idam.listingservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "price_rates")
public class PriceRate {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String  name;

    @ManyToOne
    @JoinColumn(name = "main_type", nullable = false)
    private ListingType mainType;

    public PriceRate() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ListingType getMainType() {
        return mainType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainType(ListingType mainType) {
        this.mainType = mainType;
    }
}
