package com.arwa.pokee.models;

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
@Table(name="poke")
public class Expense {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull
@Size(min=1 ,message="expense must not be blank")
private String name;


@NotNull
@Size(min=1 , message="vender must not be blank ")
private String vender;

@NotNull
@Min(value=1, message="Amount should be greater than 0")
private double amount;


@NotNull
@Size(min=1, message="description must not be blank ")
private String description;

@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;

public Expense() {}

public Expense(String name, String vender, double amount, String description) {
	this.name = name;
	this.vender = vender;
	this.amount = amount;
	this.description = description;
}

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

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}





}
