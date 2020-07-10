package edu.thi.flytransport.messaging.servicetask;
/**
 * Author: Julian Bauer
 */

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.messaging.beans.Drone;

public class CancelDroneTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Drone drone = (Drone) execution.getVariable("drone");
		if (drone != null) {
			drone.setAvailable(true);			
		}
	}

}
