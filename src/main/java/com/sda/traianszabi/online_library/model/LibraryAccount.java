package com.sda.traianszabi.online_library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "library_account")
public class LibraryAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "closed_date")
    private Date closedDate;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long id) {
        this.accountId = id;
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


}
