package com.valtech.tx.entity;

import java.time.LocalDate;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import org.springframework.beans.factory.annotation.Autowired;



@Entity
public class AtmTx {



   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;



   public AtmTx(String location) {
        super();
        this.location = location;
    }



   public AtmTx(float amount, boolean debit, LocalDate txTime, long accountId, long id, String location) {
        super();
        this.id = id;
        this.location = location;
    }



   public AtmTx() {
        super();
        // TODO Auto-generated constructor stub
    }



   public long getId() {
        return id;
    }



   public void setId(long id) {
        this.id = id;
    }



   public String getLocation() {
        return location;
    }



   public void setLocation(String location) {
        this.location = location;
    }



}