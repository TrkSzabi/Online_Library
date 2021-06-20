package com.sda.traianszabi.online_library.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Size(min = 7, max = 15)
    @Column(name = "phone")
    private String phone;

    @Email
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    private LibraryAccount libraryAccount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", libraryAccount=" + libraryAccount +
                '}';
    }
}
