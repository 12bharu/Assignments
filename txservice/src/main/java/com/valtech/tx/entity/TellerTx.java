package com.valtech.tx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TellerTx {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long tellerId;
	private String teller;
	private String branch;

	public TellerTx(String teller, String branch) {
		super();
		this.teller = teller;
		this.branch = branch;
	}

	public TellerTx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getTellerId() {
		return tellerId;
	}

	public void setTellerId(long tellerId) {
		this.tellerId = tellerId;
	}

	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
