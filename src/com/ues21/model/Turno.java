package com.ues21.model;

import java.util.Date;

public class Turno {

    private Date date;

    public Turno() {
    }

    public Turno(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
