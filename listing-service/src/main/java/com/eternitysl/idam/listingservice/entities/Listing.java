package com.eternitysl.idam.listingservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    private String addedBy;

    private String title;
    private String description;


}
