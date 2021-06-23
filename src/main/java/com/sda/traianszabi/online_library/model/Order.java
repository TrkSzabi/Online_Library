package com.sda.traianszabi.online_library.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_date")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;

    @ManyToMany
    @JoinTable(
            name = "book_orders",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bookId")})
            private List<Book> books;

    public Order(User user, Date orderDate, OrderStatus orderStatus, List<Book> books) {
        this.user = user;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.books = books;
    }
    public Order(){

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}



