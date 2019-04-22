package com.java.so;

import javax.persistence.*;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;
	@Basic(optional = false)
	private String nameProduct;
	@Basic(optional = false)
	private String description;
	@Basic(optional = false)
	private int stock;
	@Basic(optional = false)
	private double price;
		
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String nameProduct, String description, int stock, double price) {
		super();
		this.nameProduct = nameProduct;
		this.description = description;
		this.stock = stock;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}	
}

