package com.eternitysl.idam.listingservice.entities.listings.buildinglisting;

import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "building_features")
public class BuildingFeature {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_listing_id")
    @JsonIgnore
    private BuildingListing buildingListing;

    private boolean acRooms;
    private boolean furnished;
    private boolean hotWater;
    private boolean brandNew;
    private boolean beachView;
    private boolean garage;
    private boolean securitySystem;
    private boolean servantRoom;
    private boolean pool;
    private boolean internet;
    private boolean garden;
    private boolean luxury;
    private boolean riverside;
    private boolean lineWater;
    private boolean servantToilet;
    private boolean cableTv;
    private boolean enSuite;
    private boolean telephone;
    private boolean security247;
    private boolean electricity;
    private boolean colonialArchitecture;
    private boolean roofGarden;
    private boolean indoorGarden;
    private boolean waterTank;

    public int getId() {
        return id;
    }

    public boolean isAcRooms() {
        return acRooms;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public boolean isHotWater() {
        return hotWater;
    }

    public boolean isBrandNew() {
        return brandNew;
    }

    public boolean isBeachView() {
        return beachView;
    }

    public boolean isGarage() {
        return garage;
    }

    public boolean isSecuritySystem() {
        return securitySystem;
    }

    public boolean isServantRoom() {
        return servantRoom;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isInternet() {
        return internet;
    }

    public boolean isGarden() {
        return garden;
    }

    public boolean isLuxury() {
        return luxury;
    }

    public boolean isRiverside() {
        return riverside;
    }

    public boolean isLineWater() {
        return lineWater;
    }

    public boolean isServantToilet() {
        return servantToilet;
    }

    public boolean isCableTv() {
        return cableTv;
    }

    public boolean isEnSuite() {
        return enSuite;
    }

    public boolean isTelephone() {
        return telephone;
    }

    public boolean isSecurity247() {
        return security247;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public boolean isColonialArchitecture() {
        return colonialArchitecture;
    }

    public boolean isRoofGarden() {
        return roofGarden;
    }

    public boolean isIndoorGarden() {
        return indoorGarden;
    }

    public boolean isWaterTank() {
        return waterTank;
    }

    public void setAcRooms(boolean acRooms) {
        this.acRooms = acRooms;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public void setHotWater(boolean hotWater) {
        this.hotWater = hotWater;
    }

    public void setBrandNew(boolean brandNew) {
        this.brandNew = brandNew;
    }

    public void setBeachView(boolean beachView) {
        this.beachView = beachView;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public void setSecuritySystem(boolean securitySystem) {
        this.securitySystem = securitySystem;
    }

    public void setServantRoom(boolean servantRoom) {
        this.servantRoom = servantRoom;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public void setLuxury(boolean luxury) {
        this.luxury = luxury;
    }

    public void setRiverside(boolean riverside) {
        this.riverside = riverside;
    }

    public void setLineWater(boolean lineWater) {
        this.lineWater = lineWater;
    }

    public void setServantToilet(boolean servantToilet) {
        this.servantToilet = servantToilet;
    }

    public void setCableTv(boolean cableTv) {
        this.cableTv = cableTv;
    }

    public void setEnSuite(boolean enSuite) {
        this.enSuite = enSuite;
    }

    public void setTelephone(boolean telephone) {
        this.telephone = telephone;
    }

    public void setSecurity247(boolean security247) {
        this.security247 = security247;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public void setColonialArchitecture(boolean colonialArchitecture) {
        this.colonialArchitecture = colonialArchitecture;
    }

    public void setRoofGarden(boolean roofGarden) {
        this.roofGarden = roofGarden;
    }

    public void setIndoorGarden(boolean indoorGarden) {
        this.indoorGarden = indoorGarden;
    }

    public void setWaterTank(boolean waterTank) {
        this.waterTank = waterTank;
    }

    @JsonIgnore
    public BuildingListing getBuildingListing() {
        return buildingListing;
    }

    @JsonIgnore
    public void setBuildingListing(BuildingListing buildingListing) {
        this.buildingListing = buildingListing;
    }
}
