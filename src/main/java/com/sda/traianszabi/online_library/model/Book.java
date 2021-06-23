package com.sda.traianszabi.online_library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Integer id;

    @NotBlank
    @Column(name = "book_title")
    private String bookTitle;

    @NotBlank
    @Column(name = "desciprtion")
    private String description;

    @Column(name = "release_date")
    private Timestamp releaseDate;

    @Positive
    @Column(name = "price")
    private String price;

    @ManyToOne
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = Timestamp.from(Instant.now());
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}

