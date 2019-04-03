package com.eternitysl.idam.listingservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "availabilities")
public class Availability {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String  name;

    @ManyToOne
    @JoinColumn(name = "main_type", nullable = false)
    private ListingType mainType;

    public Availability() {

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
