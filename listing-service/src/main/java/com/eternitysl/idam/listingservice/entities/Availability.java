package com.eternitysl.idam.listingservice.entities;

import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.eternitysl.idam.listingservice.entities.listings.LandListing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "availabilities")
public class Availability {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "main_type", nullable = false)
    @JsonProperty
    private ListingType mainType;

    @OneToMany(mappedBy = "availability",fetch = FetchType.LAZY)
    private Set<LandListing> landListingSet;

    @OneToMany(mappedBy = "availability", fetch = FetchType.LAZY)
    private Set<BuildingListing> buildingListingSet;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;

    public Availability() {

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
