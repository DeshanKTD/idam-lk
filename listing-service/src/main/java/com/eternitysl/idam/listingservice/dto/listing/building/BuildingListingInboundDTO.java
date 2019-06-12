package com.eternitysl.idam.listingservice.dto.listing.building;

import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingFeature;

public class BuildingListingInboundDTO {
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
    private String availability;
    private BuildingFeature buildingFeature;
    private BuildingRentalInboundDTO buildingRental;
    private String buildingSellingType;

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public BuildingFeature getBuildingFeature() {
        return buildingFeature;
    }

    public BuildingRentalInboundDTO getBuildingRental() {
        return buildingRental;
    }

    public void setBuildingFeature(BuildingFeature buildingFeature) {
        this.buildingFeature = buildingFeature;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(double floorArea) {
        this.floorArea = floorArea;
    }

    public String getFloorAreaUnit() {
        return floorAreaUnit;
    }

    public void setFloorAreaUnit(String floorAreaUnit) {
        this.floorAreaUnit = floorAreaUnit;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
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

    public double getTrainDistance() {
        return trainDistance;
    }

    public void setTrainDistance(double trainDistance) {
        this.trainDistance = trainDistance;
    }

    public String getTrainDistanceUnit() {
        return trainDistanceUnit;
    }

    public void setTrainDistanceUnit(String trainDistanceUnit) {
        this.trainDistanceUnit = trainDistanceUnit;
    }

    public double getBusStopDistance() {
        return busStopDistance;
    }

    public void setBusStopDistance(double busStopDistance) {
        this.busStopDistance = busStopDistance;
    }

    public String getBusStopDistanceUnit() {
        return busStopDistanceUnit;
    }

    public void setBusStopDistanceUnit(String busStopDistanceUnit) {
        this.busStopDistanceUnit = busStopDistanceUnit;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setBuildingRental(BuildingRentalInboundDTO buildingRental) {
        this.buildingRental = buildingRental;
    }

    public String getBuildingSellingType() {
        return buildingSellingType;
    }

    public void setBuildingSellingType(String buildingSellingType) {
        this.buildingSellingType = buildingSellingType;
    }
}
