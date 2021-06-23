package com.sda.traianszabi.online_library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 15)
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    @Size(min = 5, max = 1000)
    @Column(name = "category_description")
    private String categoryDescription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer categoryId) {
        this.id = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }


}
