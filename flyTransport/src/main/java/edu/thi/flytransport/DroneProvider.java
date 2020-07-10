package edu.thi.flytransport;

/**
 * Author: Julian Bauer
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.thi.flytransport.beans.Drone;
import edu.thi.flytransport.beans.DroneClass;

public class DroneProvider {
	
	private static List<Drone> drones;
	private static HashMap<Integer,DroneClass> droneClasses;
	
	public DroneProvider() {
	}
	
	private static void init() {
		if (drones == null) {
			droneClasses = new HashMap<Integer,DroneClass>();
			DroneClass class1 = new DroneClass(2, false, 2.99,"Klasse 1");
			DroneClass class2 = new DroneClass(5, false, 3.99,"Klasse 2");
			DroneClass class3 = new DroneClass(10, false, 5.99,"Klasse 3");
			DroneClass class4 = new DroneClass(20, true, 9.99,"Klasse 4");
			droneClasses.put(1, class1);
			droneClasses.put(2, class2);
			droneClasses.put(3, class3);
			droneClasses.put(4, class4);
			drones = new ArrayList<Drone>();
			drones.add(new Drone(droneClasses.get(1)));
			drones.add(new Drone(droneClasses.get(1)));
			drones.add(new Drone(droneClasses.get(2)));
			drones.add(new Drone(droneClasses.get(3)));
			drones.add(new Drone(droneClasses.get(4)));
		}
	}
	
	public Drone findDrone(int droneClazz) {		
		init();
		if (droneClazz > 99) return null;
		for (int i = droneClazz; i<5; i++) {
			DroneClass c = droneClasses.get(i);
			for (Drone d : drones) {
				if (d.isAvailable() && d.getClazz().equals(c)) {
					return d;
				}
			}
		}
		return null;
	}

}
