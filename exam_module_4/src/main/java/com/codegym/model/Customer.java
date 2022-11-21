package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "customer")
    List<Trade> tradeList;

    public Customer() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }
}
