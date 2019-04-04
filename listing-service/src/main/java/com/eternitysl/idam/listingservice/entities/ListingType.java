package com.eternitysl.idam.listingservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "listing_types")
public class ListingType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "Need a Listing Type Name")
    private String name;

    @OneToMany(mappedBy = "mainType", fetch = FetchType.LAZY)
    private Set<ListingSubType> subTypes;

    @OneToMany(mappedBy = "mainType", fetch = FetchType.LAZY)
    private Set<PriceRate> priceRates;

    @OneToMany(mappedBy = "mainType", fetch = FetchType.LAZY)
    private Set<Availability> availabilities;


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;

    public ListingType() {
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }



    @JsonIgnore
    public Set<ListingSubType> getSubTypes() {
        return subTypes;
    }

    @JsonIgnore
    public Set<PriceRate> getPriceRates() {
        return priceRates;
    }

    @JsonIgnore
    public Set<Availability> getAvailabilities() {
        return availabilities;
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

