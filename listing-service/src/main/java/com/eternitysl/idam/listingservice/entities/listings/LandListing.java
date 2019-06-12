package com.eternitysl.idam.listingservice.entities.listings;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.entities.listings.landlisting.LandSellingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "building_listing")
public class LandListing{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private double landArea;

    private String landAreaUnit;

    @ManyToOne
    @JoinColumn(name = "price_rate", nullable = false)
    private PriceRate priceRate;

    @ManyToOne
    @JoinColumn(name = "availability", nullable = false)
    private Availability availability;


    @Enumerated(EnumType.STRING)
    private LandSellingType landSellingType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id")
    private Listing listing;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;

    @JsonIgnore
    public Listing getListing() {
        return listing;
    }

    @JsonIgnore
    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public long getId() {
        return id;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public String getLandAreaUnit() {
        return landAreaUnit;
    }

    public void setLandAreaUnit(String landAreaUnit) {
        this.landAreaUnit = landAreaUnit;
    }

    public PriceRate getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(PriceRate priceRate) {
        this.priceRate = priceRate;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }


    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public LandSellingType getLandSellingType() {
        return landSellingType;
    }

    public void setLandSellingType(LandSellingType landSellingType) {
        this.landSellingType = landSellingType;
    }

}
