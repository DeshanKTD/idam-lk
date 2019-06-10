package com.eternitysl.idam.listingservice.entities.listings;

import com.eternitysl.idam.listingservice.entities.Availability;
import com.eternitysl.idam.listingservice.entities.Listing;
import com.eternitysl.idam.listingservice.entities.constants.UnitType;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingFeature;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingRental;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingSellingType;

import javax.persistence.*;

public class BuildingListing extends Listing {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private int roomCount;

    private int bathroomCount;

    private double floorArea;

    private UnitType floorAreaUnit;

    private int floorCount;

    private double landArea;

    private UnitType landAreaUnit;

    private double trainDistance;

    private UnitType trainDistanceUnit;

    private double busstopDistance;

    private UnitType busstopDistanceUnit;

    private Availability availability;

    private BuildingSellingType buildingSellingType;

    @OneToOne(mappedBy = "buildingListing",cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    private BuildingFeature buildingFeature;

    @OneToOne(mappedBy = "buildingListing",cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private BuildingRental buildingRental;

    @Override
    public long getId() {
        return id;
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

    public UnitType getFloorAreaUnit() {
        return floorAreaUnit;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public double getLandArea() {
        return landArea;
    }

    public UnitType getLandAreaUnit() {
        return landAreaUnit;
    }

    public double getTrainDistance() {
        return trainDistance;
    }

    public UnitType getTrainDistanceUnit() {
        return trainDistanceUnit;
    }

    public double getBusstopDistance() {
        return busstopDistance;
    }

    public UnitType getBusstopDistanceUnit() {
        return busstopDistanceUnit;
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

    public void setFloorAreaUnit(UnitType floorAreaUnit) {
        this.floorAreaUnit = floorAreaUnit;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public void setLandAreaUnit(UnitType landAreaUnit) {
        this.landAreaUnit = landAreaUnit;
    }

    public void setTrainDistance(double trainDistance) {
        this.trainDistance = trainDistance;
    }

    public void setTrainDistanceUnit(UnitType trainDistanceUnit) {
        this.trainDistanceUnit = trainDistanceUnit;
    }

    public void setBusstopDistance(double busstopDistance) {
        this.busstopDistance = busstopDistance;
    }

    public void setBusstopDistanceUnit(UnitType busstopDistanceUnit) {
        this.busstopDistanceUnit = busstopDistanceUnit;
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
}
