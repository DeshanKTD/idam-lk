package com.eternitysl.idam.listingservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "listing_subtypes")
public class ListingSubType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String  name;

    @ManyToOne
    @JoinColumn(name = "main_type", nullable = false)
    private ListingType mainType;


    public ListingSubType() {
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
