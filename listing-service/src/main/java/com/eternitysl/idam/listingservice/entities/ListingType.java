package com.eternitysl.idam.listingservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "listing_types")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ListingType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "mainType")
    private Set<ListingSubType> subTypes;

    @OneToMany(mappedBy = "mainType")
    private Set<PriceRate> priceRates;

    @OneToMany(mappedBy = "mainType")
    private Set<Availability> availabilities;


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public ListingType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ListingSubType> getSubTypes() {
        return subTypes;
    }

    public int getId() {
        return id;
    }

    public Set<PriceRate> getPriceRates() {
        return priceRates;
    }

    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}

