package edu.thi.flytransport.messaging.beans;

import java.io.Serializable;

public class Drone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int maxCarryWeight;
	private boolean canFlyInBadWeatherConditions;
	private double price;
	private boolean available;
    
    public Drone() {
        this.id = 0;
        this.maxCarryWeight = 0;
        this.canFlyInBadWeatherConditions = false;
		this.available = true;
    }
    
	public Drone(int maxCarryWeight, boolean canFlyInBadWeatherConditions, double price) {
		this.id = (int)Math.ceil(Math.random()*10000);
		this.maxCarryWeight = maxCarryWeight;
		this.canFlyInBadWeatherConditions = canFlyInBadWeatherConditions;
		this.available = true;
	}

	public int getMaxCarryWeight() {
		return maxCarryWeight;
	}

	public void setMaxCarryWeight(int maxCarryWeight) {
		this.maxCarryWeight = maxCarryWeight;
	}

	public boolean isCanFlyInBadWeatherConditions() {
		return canFlyInBadWeatherConditions;
	}

	public void setCanFlyInBadWeatherConditions(boolean canFlyInBadWeatherConditions) {
		this.canFlyInBadWeatherConditions = canFlyInBadWeatherConditions;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
