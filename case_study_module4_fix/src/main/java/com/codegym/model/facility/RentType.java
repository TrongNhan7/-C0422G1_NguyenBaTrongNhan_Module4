package com.codegym.model.facility;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facilitySet;

    public RentType() {
    }

    public RentType(Integer id, String name, Set<Facility> facilitySet) {
        this.id = id;
        this.name = name;
        this.facilitySet = facilitySet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
