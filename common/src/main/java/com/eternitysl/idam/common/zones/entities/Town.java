package com.eternitysl.idam.common.zones.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {


    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonIgnore
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id",nullable = false)
    private District district;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
