package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReturnToSenderTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		/*
		 * TODO: define drone
		Drone drone = (Drone) execution.getVariable("drone");
		destination = execution.getVariable("destination");
		drone.flyPacket(destination);
		*/
		System.out.println("Paket zum Sender zurückfliegen...");
	}

}