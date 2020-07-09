package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PickupPacketTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		/*
		 * TODO: define drone
		Drone drone = (Drone) execution.getVariable("drone");
		try {
			drone.pickupPacket();
		} catch (Exception e) {*/
			System.out.println("Paket abholen...");/*
			System.out.println("Paket abholen fehlgeschlagen...");
			throw new BpmnError("400");
		}
		*/
	}

}