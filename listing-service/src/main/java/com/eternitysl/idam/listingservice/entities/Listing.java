package com.eternitysl.idam.listingservice.entities;

import com.eternitysl.idam.listingservice.entities.constants.SellerType;
import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.eternitysl.idam.listingservice.entities.listings.LandListing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "listings")
public class Listing {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "addedBy")
    private String addedBy;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SellerType sellerType;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "contactName")
    @NotNull
    private String contactName;

    @Column(name = "contactNumber")
    @NotNull
    private String contactNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listing_sub_type", nullable = false)
    private ListingSubType listingSubType;

    @Column(name = "nameUri")
    private String nameUri;

    @Column(name = "orderAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderAt;

    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private BuildingListing buildingListing;

    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private LandListing landListing;

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

    public ListingSubType getListingSubType() {
        return listingSubType;
    }

    public void setListingSubType(ListingSubType listingSubType) {
        this.listingSubType = listingSubType;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SellerType getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerType sellerType) {
        this.sellerType = sellerType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getNameUri() {
        return nameUri;
    }

    public void setNameUri(String nameUri) {
        this.nameUri = nameUri;
    }

    public Date getOrderAt() {
        return orderAt;
    }

    @JsonIgnore
    public void setOrderAt(Date orderAt) {
        this.orderAt = orderAt;
    }

    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BuildingListing getBuildingListing() {
        return buildingListing;
    }

    public void setBuildingListing(BuildingListing buildingListing) {
        this.buildingListing = buildingListing;
    }

    public LandListing getLandListing() {
        return landListing;
    }

    public void setLandListing(LandListing landListing) {
        this.landListing = landListing;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
