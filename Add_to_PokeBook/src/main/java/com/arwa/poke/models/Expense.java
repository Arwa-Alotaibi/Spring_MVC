package com.arwa.poke.models;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="Poke")
public class Expense {
// Primary key
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


//Expense
@NotNull
@Size(min = 5, max = 200)
private String name;

//Vender
@NotNull
@Size(min = 1, max = 200)
private String vender;

//Description
@NotNull
@Size(min=1, message="description must not be blank !!")
private String description;

//Amount
@NotNull
@Min(value=1, message="Amount should be greater than 0!!")
private double amount;

//This will not allow the createdAt column to be updated after creation
@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;

public Expense() {
	
}
//constructor
public Expense(String name ,String vender ,String description, double amount) {
	this.name = name ; 
	
	this.vender = vender ;
	
	this.description =description;
	
	this.amount = amount ;
}

//getters and setters :)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getVender() {
	return vender;
}
public void setVender(String vender) {
	this.vender = vender;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}


public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

//other getters and setters removed for brevity
@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}


}
