package edu.thi.flytransport.messaging;

import java.util.ArrayList;
import java.util.List;

import edu.thi.flytransport.messaging.beans.Drone;

public class DroneProvider {
	
private static List<Drone> drones;
	
	public DroneProvider() {
	}
	
	private static void init() {
		if (drones == null) {
			drones = new ArrayList<Drone>();
			drones.add(new Drone(10, false, 5.99));
			drones.add(new Drone(2, false, 2.99));
			drones.add(new Drone(5, false, 3.99));
			drones.add(new Drone(5, false, 3.99));
			drones.add(new Drone(10, true, 9.99));
		}
	}
	
	public static Drone findDrone(int weight, boolean badWeather) {
		init();
		Drone drone = null;
		for (Drone d : drones) {
			if (d.getMaxCarryWeight() >= weight && d.isAvailable()) {
				if (!badWeather) {
					drone = d;
					break;
				} else {
					if (d.isCanFlyInBadWeatherConditions()) {
						drone = d;
						break;
					}
				}
			}
		}
		return drone;
	}
	
	public static double dronePriceById(int id) {
		init();
		for (Drone d : drones) {
			if (d.getId() == id)
				return d.getPrice();
		}
		return -1;
	}

}
