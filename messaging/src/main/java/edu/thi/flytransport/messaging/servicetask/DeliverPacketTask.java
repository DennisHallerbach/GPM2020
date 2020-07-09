package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DeliverPacketTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		/*
		 * TODO: define drone
		Drone drone = (Drone) execution.getVariable("drone");
		try {
			drone.deliverPacket();
		} catch (Exception e) {*/
			System.out.println("Paket abstellen...");/*
			System.out.println("Paket abstellen fehlgeschlagen...");
			throw new BpmnError("410");
			// Drone wieder verfügbar machen
		}
		*/
	}

}