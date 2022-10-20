package com.valtech.tx.entity;

import java.time.LocalDate;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class ChequeTx {



   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chequeNo;
    private boolean outStation;
    private float collectionCharges;



   public ChequeTx() {
        super();
        // TODO Auto-generated constructor stub
    }



   public ChequeTx(float amount, boolean debit, LocalDate txTime, long accountId, long chequeNo, boolean outStation,
            float collectionCharges) {
        super();
        this.chequeNo = chequeNo;
        this.outStation = outStation;
        this.collectionCharges = collectionCharges;
    }



   public long getChequeNo() {
        return chequeNo;
    }



   public void setChequeNo(long chequeNo) {
        this.chequeNo = chequeNo;
    }



   public boolean isOutStation() {
        return outStation;
    }



   public void setOutStation(boolean outStation) {
        this.outStation = outStation;
    }



   public float getCollectionCharges() {
        return collectionCharges;
    }



   public void setCollectionCharges(float collectionCharges) {
        this.collectionCharges = collectionCharges;
    }



}