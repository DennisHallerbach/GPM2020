package edu.thi.flytransport.beans;

/**
 * Author: Julian Bauer
 */

import java.io.Serializable;

public class DroneClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int maxCarryWeight;
	private boolean canFlyInBadWeatherConditions;
	private double price;
	private String name;
	


	public DroneClass() {
		this.id = -1;
		this.maxCarryWeight = -1;
		this.canFlyInBadWeatherConditions = false;
		this.price = -1;
		this.name = "";
	}
	
	public DroneClass(int maxCarryWeight, boolean canFlyInBadWeatherConditions, double price, String name) {
		this.id = (int)Math.ceil(Math.random()*10000);
		this.maxCarryWeight = maxCarryWeight;
		this.price = price;
		this.canFlyInBadWeatherConditions = canFlyInBadWeatherConditions;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
