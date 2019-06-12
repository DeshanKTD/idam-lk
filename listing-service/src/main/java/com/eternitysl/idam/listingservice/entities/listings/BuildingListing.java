package com.eternitysl.idam.listingservice.entities.listings;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.entities.constants.UnitType;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingFeature;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingRental;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingSellingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "building_listing")
public class BuildingListing {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private int roomCount;

    private int bathroomCount;

    private double floorArea;

    private String floorAreaUnit;

    private int floorCount;

    private double landArea;

    private String landAreaUnit;

    private double trainDistance;

    private String trainDistanceUnit;

    private double busStopDistance;

    private String busStopDistanceUnit;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "availability", nullable = false)
    private Availability availability;

    @Enumerated(EnumType.STRING)
    private BuildingSellingType buildingSellingType;

    @OneToOne(mappedBy = "buildingListing",cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    private BuildingFeature buildingFeature;

    @OneToOne(mappedBy = "buildingListing",cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private BuildingRental buildingRental;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id")
    private Listing listing;

    public long getId() {
        return id;
    }

    @JsonIgnore
    public Listing getListing() {
        return listing;
    }

    @JsonIgnore
    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public double getFloorArea() {
        return floorArea;
    }

    public String getFloorAreaUnit() {
        return floorAreaUnit;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public double getLandArea() {
        return landArea;
    }

    public String getLandAreaUnit() {
        return landAreaUnit;
    }

    public double getTrainDistance() {
        return trainDistance;
    }

    public String getTrainDistanceUnit() {
        return trainDistanceUnit;
    }

    public double getBusStopDistance() {
        return busStopDistance;
    }

    public String getBusStopDistanceUnit() {
        return busStopDistanceUnit;
    }

    public Availability getAvailability() {
        return availability;
    }

    public BuildingSellingType getBuildingSellingType() {
        return buildingSellingType;
    }

    public BuildingFeature getBuildingFeature() {
        return buildingFeature;
    }

    public BuildingRental getBuildingRental() {
        return buildingRental;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public void setFloorArea(double floorArea) {
        this.floorArea = floorArea;
    }

    public void setFloorAreaUnit(String floorAreaUnit) {
        this.floorAreaUnit = floorAreaUnit;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public void setLandAreaUnit(String landAreaUnit) {
        this.landAreaUnit = landAreaUnit;
    }

    public void setTrainDistance(double trainDistance) {
        this.trainDistance = trainDistance;
    }

    public void setTrainDistanceUnit(String trainDistanceUnit) {
        this.trainDistanceUnit = trainDistanceUnit;
    }

    public void setBusStopDistance(double busStopDistance) {
        this.busStopDistance = busStopDistance;
    }

    public void setBusStopDistanceUnit(String busStopDistanceUnit) {
        this.busStopDistanceUnit = busStopDistanceUnit;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setBuildingSellingType(BuildingSellingType buildingSellingType) {
        this.buildingSellingType = buildingSellingType;
    }

    public void setBuildingFeature(BuildingFeature buildingFeature) {
        this.buildingFeature = buildingFeature;
    }

    public void setBuildingRental(BuildingRental buildingRental) {
        this.buildingRental = buildingRental;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
