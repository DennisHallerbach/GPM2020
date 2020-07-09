package edu.thi.flytransport.messaging.beans;

import java.io.Serializable;

public class Drone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private DroneClass clazz;
	private boolean available;

	public Drone() {
        this.id = -1;
        this.clazz = null;
        this.setAvailable(false);
    }
    
	public Drone(DroneClass clazz) {
		this.id = (int)Math.ceil(Math.random()*10000);
		this.clazz = clazz;
		this.setAvailable(true);
	}

	public int getId() {
		return id;
	}
    
    public DroneClass getClazz() {
		return clazz;
	}

	public void setClazz(DroneClass clazz) {
		this.clazz = clazz;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
