package com.eternitysl.idam.listingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "availabilities")
public class Availability {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String  name;

    @ManyToOne
    @JoinColumn(name = "main_type", nullable = false)
    @JsonProperty
    private ListingType mainType;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;

    public Availability() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ListingType getMainType() {
        return mainType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainType(ListingType mainType) {
        this.mainType = mainType;
    }
}
