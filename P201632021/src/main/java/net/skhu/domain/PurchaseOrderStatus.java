package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class PurchaseOrderStatus {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 String status;

	   @OneToMany(mappedBy="purchaseOrderStatus")
	   List<PurchaseOrders> PurchaseOrders;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PurchaseOrders> getPurchaseOrders() {
		return PurchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrders> purchaseOrders) {
		PurchaseOrders = purchaseOrders;
	}
	 
	 
}
