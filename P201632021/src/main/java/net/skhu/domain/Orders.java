package net.skhu.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 @ManyToOne
	 @JoinColumn(name="employee_id")
	 Employees employees;
	 
	 @ManyToOne
	 @JoinColumn(name="customer_id")
	 Customers customers;
	 
	 @Column(name="order_date")
	 Date orderDate;
	 
	 @Column(name="shipped_date")
	 Date shippedDate;
	 
	 @ManyToOne
	 @JoinColumn(name="shipper_id")
	 Shippers shippers;
	 
	 @Column(name="ship_name")
	 String shipName;
	 
	 @Column(name="ship_address")
	 String shipAddress;
	 
	 @Column(name="ship_city")
	 String shipCity;
	 
	 @Column(name="ship_state_province")
	 String shipStateProvince;
	 
	 @Column(name="ship_zip_postal_code")
	 String shipZipPostalCode;
	 
	 @Column(name="shipping_fee")
	 BigDecimal shippingFee;
	
	 BigDecimal taxes;
	 
	 @Column(name="payment_type")
	 String paymentType;
	 
	 @Column(name="paid_date")
	 Date paidDate;
	 
	 String notes;
	 
	 @Column(name="tax_rate")
	 Double taxRate;
	 
	 @ManyToOne
	 @JoinColumn(name="tax_status_id")
	 OrdersTaxStatus ordersTaxStatus;
	 
	 @ManyToOne
	 @JoinColumn(name="status_id")
	 OrdersStatus ordersStatus;

	   @OneToMany(mappedBy="orders")
	   List<OrderDetails> orderDetails;
	   
	   @OneToMany(mappedBy="orders")
	   List<Invoices> invoices;
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Shippers getShippers() {
		return shippers;
	}

	public void setShippers(Shippers shippers) {
		this.shippers = shippers;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipStateProvince() {
		return shipStateProvince;
	}

	public void setShipStateProvince(String shipStateProvince) {
		this.shipStateProvince = shipStateProvince;
	}

	public String getShipZipPostalCode() {
		return shipZipPostalCode;
	}

	public void setShipZipPostalCode(String shipZipPostalCode) {
		this.shipZipPostalCode = shipZipPostalCode;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public OrdersTaxStatus getOrdersTaxStatus() {
		return ordersTaxStatus;
	}

	public void setOrdersTaxStatus(OrdersTaxStatus ordersTaxStatus) {
		this.ordersTaxStatus = ordersTaxStatus;
	}

	public OrdersStatus getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(OrdersStatus ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<Invoices> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoices> invoices) {
		this.invoices = invoices;
	}
	 
}
