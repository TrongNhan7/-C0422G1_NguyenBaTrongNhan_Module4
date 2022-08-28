package com.codegym.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_facility")
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    @Column(name = "status_facility")
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetailSet;

    public AttachFacility() {
    }

    public AttachFacility(Integer id, String name, Double cost, String unit, String status, Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetailSet = contractDetailSet;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
