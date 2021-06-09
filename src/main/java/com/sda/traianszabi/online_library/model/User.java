package com.sda.traianszabi.online_library.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    private LibraryAccount libraryAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LibraryAccount getLibraryAccount() {
        return libraryAccount;
    }

    public void setLibraryAccount(LibraryAccount libraryAccount) {
        this.libraryAccount = libraryAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", libraryAccount=" + libraryAccount +
                '}';
    }
}
