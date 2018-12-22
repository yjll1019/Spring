package net.skhu.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrderDetails {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 @ManyToOne
	 @JoinColumn(name="purchase_order_id")
	 PurchaseOrders purchaseOrders;
	 
	 @ManyToOne
	 @JoinColumn(name="product_id")
	 Products products;
	 
	 @ManyToOne
	 @JoinColumn(name="inventory_id")
	 InventoryTransactions inventoryTransactions;
	 
	 BigDecimal quantity;
	 
	 BigDecimal unitCost;
	 
	 Date dateReceived;
	 
	 int postedToInventory;
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PurchaseOrders getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(PurchaseOrders purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public InventoryTransactions getInventoryTransactions() {
		return inventoryTransactions;
	}

	public void setInventoryTransactions(InventoryTransactions inventoryTransactions) {
		this.inventoryTransactions = inventoryTransactions;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public int getPostedToInventory() {
		return postedToInventory;
	}

	public void setPostedToInventory(int postedToInventory) {
		this.postedToInventory = postedToInventory;
	}
	 
	 
	 
}
