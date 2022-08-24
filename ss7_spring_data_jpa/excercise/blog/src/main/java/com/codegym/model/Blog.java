package com.codegym.model;

import javax.persistence.*;


@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @Column(name = "date_create", columnDefinition = "Date")
    private String dateCreate;
    public boolean status = false;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, referencedColumnName = "idCategory")
    private Category category;

    public Blog(Integer id, String title, String content, String dateCreate, boolean status, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreate = dateCreate;
        this.status = status;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String dateCreate, boolean status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Blog(Integer id, String title, String content, String dateCreate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
