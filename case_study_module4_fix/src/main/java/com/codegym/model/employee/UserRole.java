package com.codegym.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

//    @EmbeddedId
//    private UserRoleKey id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }
//
//    public UserRole(UserRoleKey id, User user, Role role) {
//        this.id = id;
//        this.user = user;
//        this.role = role;
//    }
//
//    public UserRoleKey getId() {
//        return id;
//    }
//
//    public void setId(UserRoleKey id) {
//        this.id = id;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
