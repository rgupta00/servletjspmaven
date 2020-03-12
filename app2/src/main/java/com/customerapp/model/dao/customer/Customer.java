package com.customerapp.model.dao.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="customer_pojo")
@Table(name = "cust_table_crud")
public class Customer {
	@Column(name = "cust_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cust_name", nullable = false, length = 100)
	private String name;
	@Column(name = "cust_address", nullable = false, length = 100)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "cust_dob", nullable = false)
	private Date dob;

	public Customer(String name, String address, Date dob) {
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	public Customer(int id, String name, String address, Date dob) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	public Customer() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ ", dob=" + dob + "]";
	}

	
}
