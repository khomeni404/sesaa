package net.softengine.common.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 2016-10-12 for qrf
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Version : 1.0
 */
@Entity
@Table(name = "COM_DIVISION")
public class Division implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Country country;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "division")
    @Fetch(FetchMode.SELECT)
    private List<District> districtList = new ArrayList<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }
}
