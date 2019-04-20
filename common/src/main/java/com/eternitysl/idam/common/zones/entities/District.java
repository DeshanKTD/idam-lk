package com.eternitysl.idam.common.zones.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private Set<Town> towns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Set<Town> getTowns() {
        return towns;
    }
}
