package net.skhu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class InventoryTransactionTypes {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 String typeName;

	   @OneToMany(mappedBy="inventoryTransactionTypes")
	   List<InventoryTransactions> inventoryTransactions;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<InventoryTransactions> getInventoryTransactions() {
		return inventoryTransactions;
	}

	public void setInventoryTransactions(List<InventoryTransactions> inventoryTransactions) {
		this.inventoryTransactions = inventoryTransactions;
	}
	 
	 
}
