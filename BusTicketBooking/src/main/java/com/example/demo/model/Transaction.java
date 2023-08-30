package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transdetails")
public class Transaction {
@Id
private int transid;
private String type;
private float amount;
public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
public Transaction(int transid, String type, float amount) {
	super();
	this.transid = transid;
	this.type = type;
	this.amount = amount;
}
public int getTransid() {
	return transid;
}
public void setTransid(int transid) {
	this.transid = transid;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}

}
