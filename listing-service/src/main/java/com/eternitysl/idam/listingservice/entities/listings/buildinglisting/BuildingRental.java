package com.eternitysl.idam.listingservice.entities.listings.buildinglisting;

import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.entities.constants.UnitType;
import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

public class BuildingRental {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_listing_id")
    private BuildingListing buildingListing;


    private int minimumTerm;

    private UnitType minTermUnit;

    private boolean billsIncluded;

    private int depositCount;

    private UnitType depositUnit;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;
}
