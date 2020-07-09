package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DeliverPacketSenderTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		/*
		 * TODO: define drone
		Drone drone = (Drone) execution.getVariable("drone");
		drone.deliverPacket();
		*/
		System.out.println("Paket beim Sender abstellen...");
	}

}
