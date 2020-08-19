package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity		// convert this Java Bean to a JPA Entity, so it is able to map to DB
@Table(name = "MSI_PRODUCT")	// Map this class with the table
public class Product {
	
	@Id
	@SequenceGenerator(name="msi_product_seq_gen", sequenceName="MSI_PRODUCT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="msi_product_seq_gen")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String brand;
	
	@Column
	private int price;
	
	@Column
	private int stock;
	
	@Column
	private String image;

	public Product() {
		super();
	}

	public Product(int id, String name, String brand, int price, int stock, String image) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.image = image;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", stock=" + stock
				+ ", image=" + image + "]";
	}
}