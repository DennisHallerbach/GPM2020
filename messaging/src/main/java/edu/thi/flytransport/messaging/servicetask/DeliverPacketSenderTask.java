package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.messaging.beans.Drone;

public class DeliverPacketSenderTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Drone drone = (Drone) execution.getVariable("drone");
		drone.deliverPacket("Sender");
	}

}
