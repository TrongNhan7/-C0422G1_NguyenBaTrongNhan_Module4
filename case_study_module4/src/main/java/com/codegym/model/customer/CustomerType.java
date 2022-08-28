package com.codegym.model.customer;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "customerType")
    Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(Integer id, String name, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.customerSet = customerSet;
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

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
