package com.example.areebmalik1989.bmimonitor.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;
import io.objectbox.annotation.Unique;

@Entity
public class BmiRecord {

    @Id
    long id;

    double bmi;

    @Transient
    transient Calendar calendar;

    @Unique
    Date date;

    public BmiRecord(){}

    public BmiRecord(double bmi){

        this.bmi = bmi;
        calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = formatter.format(calendar.getTime());

        try {
            date = formatter.parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public BmiRecord(long id, double bmi, Calendar calendar) {
        this.id = id;
        this.bmi = bmi;
        this.calendar = calendar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
