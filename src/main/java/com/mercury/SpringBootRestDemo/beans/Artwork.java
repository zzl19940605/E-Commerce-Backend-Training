package com.mercury.SpringBootRestDemo.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Artwork")
public class Artwork implements Comparable<Artwork> {
	
	@Id
	@SequenceGenerator(name="Artwork_seq_gen", sequenceName="ARTWORK_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="artwork_seq_gen")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String sold;
	
	@Column
	private int price;

	public Artwork() {
		super();
	}

	public Artwork(int id, String sold, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.sold = sold;
		this.price= price;
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
		this.name=name;
	}
	public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", name= " + name + ", sold=" + sold + ", price=" + price+ "]";
	}
	
	@Override
	public int compareTo(Artwork a) {
		return (this.price - a.price);
	}
}
