package edu.thi.flytransport.beans;

/**
 * Author: Julian Bauer
 */

import java.io.Serializable;
import java.util.Random;

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

	public void deliverPacket(String to) throws Exception {
		System.out.println(String.format("Paket beim %s abstellen...", to));
		if (to.equals("Empfänger")) {
			Random r = new Random();
			if(r.nextInt(100) > 70) {
				System.out.println("Paket abstellen fehlgeschlagen...");
				throw new Exception("Paket abstellen fehlgeschlagen");
			};	
		}
		this.setAvailable(true);		
	}

	public void pickupPacket() throws Exception {
		System.out.println("Paket abholen...");
		Random r = new Random();
		if(r.nextInt(100) > 80) {
			System.out.println("Paket abholen fehlgeschlagen...");
			throw new Exception("Paket abholen fehlgeschlagen");
		};		
	}

	public void flyPacket(String to) {
		System.out.println(String.format("Paket zum %s fliegen...", to));		
	}
	
}
