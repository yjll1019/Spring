package net.skhu.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Invoices {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 
	 @ManyToOne
	 @JoinColumn(name="order_id")
	 Orders orders;

	 
	 Date invoiceDate;
	 Date dueDate;
	 
	 BigDecimal tax;
	 BigDecimal shipping;
	 BigDecimal amountDue;
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
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public BigDecimal getShipping() {
		return shipping;
	}
	public void setShipping(BigDecimal shipping) {
		this.shipping = shipping;
	}
	public BigDecimal getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	 
}
