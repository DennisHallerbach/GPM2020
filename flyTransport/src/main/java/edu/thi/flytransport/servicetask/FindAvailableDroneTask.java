package edu.thi.flytransport.servicetask;
/**
 * Author: Julian Bauer
 */

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.DroneProvider;
import edu.thi.flytransport.beans.Drone;

public class FindAvailableDroneTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		int droneClazz = (int) execution.getVariable("droneClass");
		DroneProvider dP = new DroneProvider();
		Drone drone = dP.findDrone(droneClazz);
		if (drone != null) {
			drone.setAvailable(false);
			execution.setVariable("droneAvailable", true);
			execution.setVariable("drone", drone);
		} else {
			execution.setVariable("droneAvailable", false);			
		}
	}

}
