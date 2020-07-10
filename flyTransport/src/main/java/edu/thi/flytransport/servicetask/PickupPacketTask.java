package edu.thi.flytransport.servicetask;
/**
 * Author: Julian Bauer
 */

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.beans.Drone;

public class PickupPacketTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Drone drone = (Drone) execution.getVariable("drone");
		try {
			drone.pickupPacket();
		} catch (Exception e) {
			throw new BpmnError("400");
		}
	}

}