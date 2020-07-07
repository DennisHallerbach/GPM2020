package edu.thi.flytransport.messaging.beans;

import java.io.Serializable;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private int invoiceId;
	private long sum;
	
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
	
	public Invoice (int orderId, long sum) {
		this.orderId = orderId;
		this.invoiceId = (int)Math.ceil(Math.random()*10000);
		this.sum = sum;		
	}
	
	public String getDescription() {
		return String.format("Invoice for order %s. Total sum: %s",orderId,sum);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public int getInvoiceId() {
		return invoiceId;
	}	
	

}
