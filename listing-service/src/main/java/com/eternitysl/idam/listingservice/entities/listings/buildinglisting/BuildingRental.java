package com.eternitysl.idam.listingservice.entities.listings.buildinglisting;

import com.eternitysl.idam.listingservice.entities.constants.UnitType;
import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "building_rentals")
public class BuildingRental {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_listing_id")
    private BuildingListing buildingListing;


    private int minimumTerm;

    private String minTermUnit;

    private boolean billsIncluded;

    private int depositCount;

    private String depositUnit;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;


    public long getId() {
        return id;
    }

    public BuildingListing getBuildingListing() {
        return buildingListing;
    }

    public void setBuildingListing(BuildingListing buildingListing) {
        this.buildingListing = buildingListing;
    }

    public int getMinimumTerm() {
        return minimumTerm;
    }

    public void setMinimumTerm(int minimumTerm) {
        this.minimumTerm = minimumTerm;
    }

    public String getMinTermUnit() {
        return minTermUnit;
    }

    public void setMinTermUnit(String minTermUnit) {
        this.minTermUnit = minTermUnit;
    }

    public boolean isBillsIncluded() {
        return billsIncluded;
    }

    public void setBillsIncluded(boolean billsIncluded) {
        this.billsIncluded = billsIncluded;
    }

    public int getDepositCount() {
        return depositCount;
    }

    public void setDepositCount(int depositCount) {
        this.depositCount = depositCount;
    }

    public String getDepositUnit() {
        return depositUnit;
    }

    public void setDepositUnit(String depositUnit) {
        this.depositUnit = depositUnit;
    }

    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public Date getUpdatedAt() {
        return updatedAt;
    }
}
