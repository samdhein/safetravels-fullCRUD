package com.samhein.safetravels.models;

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
@Table(name="expenses")
public class Expense {
	// need: attributes, createdAt/updatedAt, constructors, getters/setters, PrePersist/PreUpdate
	
	// attributes
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Must enter expense name")
	@Size(min = 2, max = 200, message="Need a longer name")
	private String name;
	
	@NotNull(message="Must enter vendor")
	@Size(min = 2, max = 200, message="Need a longer vendor")
	private String vendor;
	
	@NotNull(message="Must enter price")
	@Min(0)
	private Double price;
	
	// createdAt
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	//updatedAt
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //constructors
    public Expense() {}
    
    public Expense(String name, String vendor, Double price) {
    	this.name = name;
    	this.vendor = vendor;
    	this.price = price;
    }
    
    // getters & setters
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
    
    //PrePersist and PreUpdate
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    
    
    
    
}
