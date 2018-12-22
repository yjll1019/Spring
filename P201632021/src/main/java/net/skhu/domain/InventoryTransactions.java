package net.skhu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class InventoryTransactions {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	 @ManyToOne
	 @JoinColumn(name="transaction_type")
	 InventoryTransactionTypes inventoryTransactionTypes;

	 Date transactionCreatedDate;
	 
	 Date transactionModifiedDate;
	 
	 @ManyToOne
	 @JoinColumn(name="product_id")
	 Products products;
	 
	 int quantity;
	 
	 @OneToOne
	 @JoinColumn(name="purchase_order_id")
	 PurchaseOrders purchaseOrders;

	 @ManyToOne
	 @JoinColumn(name="customer_order_id")
	 Customers customers;
	 
	 String comments;
	 
		@OneToMany(mappedBy = "inventoryTransactions")
		List<PurchaseOrderDetails> purchaseOrderDetails;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public InventoryTransactionTypes getInventoryTransactionTypes() {
			return inventoryTransactionTypes;
		}

		public void setInventoryTransactionTypes(InventoryTransactionTypes inventoryTransactionTypes) {
			this.inventoryTransactionTypes = inventoryTransactionTypes;
		}

		public Date getTransactionCreatedDate() {
			return transactionCreatedDate;
		}

		public void setTransactionCreatedDate(Date transactionCreatedDate) {
			this.transactionCreatedDate = transactionCreatedDate;
		}

		public Date getTransactionModifiedDate() {
			return transactionModifiedDate;
		}

		public void setTransactionModifiedDate(Date transactionModifiedDate) {
			this.transactionModifiedDate = transactionModifiedDate;
		}

		public Products getProducts() {
			return products;
		}

		public void setProducts(Products products) {
			this.products = products;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public PurchaseOrders getPurchaseOrders() {
			return purchaseOrders;
		}

		public void setPurchaseOrders(PurchaseOrders purchaseOrders) {
			this.purchaseOrders = purchaseOrders;
		}

		public Customers getCustomers() {
			return customers;
		}

		public void setCustomers(Customers customers) {
			this.customers = customers;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public List<PurchaseOrderDetails> getPurchaseOrderDetails() {
			return purchaseOrderDetails;
		}

		public void setPurchaseOrderDetails(List<PurchaseOrderDetails> purchaseOrderDetails) {
			this.purchaseOrderDetails = purchaseOrderDetails;
		}
	 
	  
}
