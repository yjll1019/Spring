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
import javax.persistence.OneToOne;
@Entity
public class PurchaseOrders {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	 @ManyToOne
	 @JoinColumn(name="supplier_id")
	 Suppliers suppliers;
	 
	 @ManyToOne
	 @JoinColumn(name="created_by")
	 Employees employees;
	 
	 @ManyToOne
	 @JoinColumn(name="status_id")
	 PurchaseOrderStatus purchaseOrderStatus;
	 
	 Date submittedDate;
	 
	 Date creationDate;
	 
	 Date expectedDate;
	 
	 BigDecimal shippingFee;
	 
	 BigDecimal taxes;
	 
	 Date paymentDate;
	 
	 BigDecimal paymentAmount;
	 
	 String paymentMethod;
	 
	 String notes;
	 
	 Integer approvedBy;
	 
	 Date approvedDate;
	 
	 int submittedBy;

	  @OneToOne(mappedBy="purchaseOrders")
	  InventoryTransactions inventoryTransactions;
	 
		@OneToMany(mappedBy = "purchaseOrders")
		List<PurchaseOrderDetails> purchaseOrderDetails;
	 
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public void setPurchaseOrderStatus(PurchaseOrderStatus purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	public Integer getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public int getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
		this.submittedBy = submittedBy;
	}

	public InventoryTransactions getInventoryTransactions() {
		return inventoryTransactions;
	}

	public void setInventoryTransactions(InventoryTransactions inventoryTransactions) {
		this.inventoryTransactions = inventoryTransactions;
	}

	public List<PurchaseOrderDetails> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetails> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}
	 
	 
	 
}
