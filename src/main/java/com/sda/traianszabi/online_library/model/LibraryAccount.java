package com.sda.traianszabi.online_library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "library_account")
public class LibraryAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "closed_date")
    private Date closedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    @Override
    public String toString() {
        return "LibraryAccount{" +
                "id=" + id +
                ", isClosed=" + isClosed +
                ", creationDate=" + creationDate +
                ", closedDate=" + closedDate +
                '}';
    }
}
