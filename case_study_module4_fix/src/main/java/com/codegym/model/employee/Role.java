package com.codegym.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name")
    private String name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    public Role() {
    }

    public Role(Integer id, String name, Set<UserRole> userRoles) {
        this.id = id;
        this.name = name;
        this.userRoles = userRoles;
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
