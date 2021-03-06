package com.eternitysl.idam.listingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "listing_subtypes")
public class ListingSubType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "The Sub Listing Name cannot be blank")
    private String name;

    @Column(name = "local_name", unique = true)
    @NotBlank(message = "The Sub Listing Local Name cannot be blank")
    private String localName;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main_type", nullable = false)
    @JsonProperty
    private ListingType mainType;


    @OneToMany(mappedBy = "listingSubType", fetch = FetchType.LAZY)
    private Set<Listing> listings;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;


    public ListingSubType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListingType getMainType() {
        return mainType;
    }

    @JsonIgnore
    public void setMainType(ListingType mainType) {
        this.mainType = mainType;
    }

    public int getId() {
        return id;
    }

    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
