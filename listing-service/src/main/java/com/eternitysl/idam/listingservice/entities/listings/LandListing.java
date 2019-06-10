package com.eternitysl.idam.listingservice.entities.listings;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.entities.PriceRate;
import com.eternitysl.idam.listingservice.entities.constants.UnitType;
import com.eternitysl.idam.listingservice.entities.listings.landlisting.LandSellingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LandListing extends Listing {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private double landArea;

    @Enumerated(EnumType.STRING)
    private UnitType landAreaUnit;

    @ManyToOne
    @JoinColumn(name = "price_rate", nullable = false)
    private PriceRate priceRate;

    @ManyToOne
    @JoinColumn(name = "availability", nullable = false)
    private Availability availability;


    @Enumerated(EnumType.STRING)
    private LandSellingType landSellingType;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;


    @Override
    public long getId() {
        return id;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public UnitType getLandAreaUnit() {
        return landAreaUnit;
    }

    public void setLandAreaUnit(UnitType landAreaUnit) {
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

    @Override
    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
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
