package com.eternitysl.idam.listingservice.entities;

import com.eternitysl.idam.listingservice.entities.constants.SellerType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    @Column(name = "contactName")
    @NotNull
    private String contactName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main_type", nullable = false)
    private ListingType mainType;

    @Column(name = "nameUri")
    private String nameUri;

    @Column(name = "orderAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderAt;


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

    public String getAddedBy() {
        return addedBy;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public SellerType getSellerType() {
        return sellerType;
    }

    public String getContactName() {
        return contactName;
    }

    public ListingType getMainType() {
        return mainType;
    }

    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameUri() {
        return nameUri;
    }

    public Date getOrderAt() {
        return orderAt;
    }

    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSellerType(SellerType sellerType) {
        this.sellerType = sellerType;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setMainType(ListingType mainType) {
        this.mainType = mainType;
    }

    public void setNameUri(String nameUri) {
        this.nameUri = nameUri;
    }

    @JsonIgnore
    public void setOrderAt(Date orderAt) {
        this.orderAt = orderAt;
    }

    @JsonIgnore
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
