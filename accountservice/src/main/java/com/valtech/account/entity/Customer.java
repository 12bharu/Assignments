package com.valtech.account.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String mobile;
	private LocalDate birtDate;
	private String address;
	private String customerType;
	private int pincode;
	
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String name, String email, String mobile, LocalDate birtDate, String address,
			String customerType, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birtDate = birtDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}
	

	public Customer(String name, String email, String mobile, LocalDate birtDate, String address, String customerType,
			int pincode) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birtDate = birtDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getBirtDate() {
		return birtDate;
	}
	public void setBirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	

}
