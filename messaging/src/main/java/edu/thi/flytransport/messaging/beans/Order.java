package edu.thi.flytransport.messaging.beans;

import java.io.Serializable;

public class Order implements Serializable{
private static final long serialVersionUID = 1L;
    
    private int orderid;
    private String username;
    private String password;
    private long packetLength;
    private long packetWidth;
    private long packetHeight;
    private long packetWeight;
    
    public Order() {
        this.orderid = 0;
        this.username = null;
		this.password = null;
		this.packetLength = 0;
		this.packetWidth = 0;
		this.packetHeight = 0;
		this.packetWeight = 0;
    }
    
	public Order(String username, String password, long packetLength, long packetWidth, long packetHeight,
			long packetWeight) {
		this.orderid = (int)Math.ceil(Math.random()*10000);
		this.username = username;
		this.password = password;
		this.packetLength = packetLength;
		this.packetWidth = packetWidth;
		this.packetHeight = packetHeight;
		this.packetWeight = packetWeight;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPacketLength() {
		return packetLength;
	}
	public void setPacketLength(long packetLength) {
		this.packetLength = packetLength;
	}
	public long getPacketWidth() {
		return packetWidth;
	}
	public void setPacketWidth(long packetWidth) {
		this.packetWidth = packetWidth;
	}
	public long getPacketHeight() {
		return packetHeight;
	}
	public void setPacketHeight(long packetHeight) {
		this.packetHeight = packetHeight;
	}
	public long getPacketWeight() {
		return packetWeight;
	}
	public void setPacketWeight(long packetWeight) {
		this.packetWeight = packetWeight;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
}
