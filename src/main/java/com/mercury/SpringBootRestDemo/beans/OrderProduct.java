package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MSI_ORDER_PRODUCT")
public class OrderProduct {
	
	@Id
	@SequenceGenerator(name="msi_order_product_seq_gen", sequenceName="MSI_ORDER_PRODUCT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="msi_order_product_seq_gen")
	private int id;
	
	@Column
	private int qty;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ORDER_ID")		// ORDER_ID column in this table will be used to join with Order table on @Id column
//	@JsonIgnore		= on both getter and setter
	private Order order;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public OrderProduct() {
		super();
	}

	public OrderProduct(int id, int qty, Order order, Product product) {
		super();
		this.id = id;
		this.qty = qty;
		this.order = order;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@JsonIgnore		// will not generate JSON from this field
	public Order getOrder() {
		return order;
	}

//	@JsonIgnore		// will not receive JSON for this field
	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", qty=" + qty + ", order=" + order + ", product=" + product + "]";
	}
}
