package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class OrdersTaxStatus {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 String taxStatusName;

	  @OneToMany(mappedBy="ordersTaxStatus")
	  List<Orders> orders;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaxStatusName() {
		return taxStatusName;
	}

	public void setTaxStatusName(String taxStatusName) {
		this.taxStatusName = taxStatusName;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	 
	 
}
