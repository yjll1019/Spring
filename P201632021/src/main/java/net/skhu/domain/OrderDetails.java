package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 @ManyToOne
	 @JoinColumn(name="order_id")
	 Orders orders;
	 
	 @ManyToOne
	 @JoinColumn(name="product_id")
	 Products products;
	 
	 @ManyToOne
	 @JoinColumn(name="status_id")
	 OrderDetailsStatus orderDetailsStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public OrderDetailsStatus getOrderDetailsStatus() {
		return orderDetailsStatus;
	}

	public void setOrderDetailsStatus(OrderDetailsStatus orderDetailsStatus) {
		this.orderDetailsStatus = orderDetailsStatus;
	}
	 
	 
}
