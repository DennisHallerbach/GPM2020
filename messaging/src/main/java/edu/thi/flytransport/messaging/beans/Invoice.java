package edu.thi.flytransport.messaging.beans;

import java.io.Serializable;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private int invoiceId;
	private double sum;
	
	public Invoice() {
		this.orderId = 0;
		this.invoiceId = 0;
		this.sum = 0;
	}
	
	public Invoice(int orderId) {
		this.orderId = orderId;
		this.invoiceId = (int)Math.ceil(Math.random()*10000);
		this.sum = 0;
	}
	
	public Invoice (int orderId, double sum) {
		this.orderId = orderId;
		this.invoiceId = (int)Math.ceil(Math.random()*10000);
		this.sum = sum;		
	}
	
	public String getDescription() {
		return String.format("Rechnung für Bestellung %s", orderId, sum);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double d) {
		this.sum = d;
	}

	public int getInvoiceId() {
		return invoiceId;
	}	
	

}
