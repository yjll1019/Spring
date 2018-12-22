package net.skhu.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Products {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 String supplierIds;
	 
	 String productCode;
	 
	 String productName;
	 
	 String description;
	 
	 BigDecimal standardCost;
	 
	 BigDecimal listPrice;
	 
	 int reorderLevel;
	 
	 int targetLevel;
	 
	 String quantityPerUnit;
	 
	 int discontinued;
	 
	 int minimumReorderQuantity;
	 
	 String category;
	 
	 @Lob
	 byte[]attachments;

	 @JsonIgnore
		@OneToMany(mappedBy = "products")
		List<PurchaseOrderDetails> purchaseOrderDetails;
	 @JsonIgnore
		@OneToMany(mappedBy = "products")
		List<OrderDetails> orderDetails;
	 
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplierIds() {
		return supplierIds;
	}

	public void setSupplierIds(String supplierIds) {
		this.supplierIds = supplierIds;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getTargetLevel() {
		return targetLevel;
	}

	public void setTargetLevel(int targetLevel) {
		this.targetLevel = targetLevel;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public int getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(int discontinued) {
		this.discontinued = discontinued;
	}

	public int getMinimumReorderQuantity() {
		return minimumReorderQuantity;
	}

	public void setMinimumReorderQuantity(int minimumReorderQuantity) {
		this.minimumReorderQuantity = minimumReorderQuantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getAttachments() {
		return attachments;
	}

	public void setAttachments(byte[] attachments) {
		this.attachments = attachments;
	}


	public List<PurchaseOrderDetails> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetails> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	 
	 
	 
	 
}
