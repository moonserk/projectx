package com.projectx.client;

import java.util.Date;

public class Contract {
    //private Long id;
    public String number;
    public Date dateCreation;

    public Date lastUpdate;

    public Contract(String number, Date dateCreation, Date lastUpdate) {
      //  this.id = id;
        this.number = number;
        this.dateCreation = dateCreation;
        this.lastUpdate = lastUpdate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
