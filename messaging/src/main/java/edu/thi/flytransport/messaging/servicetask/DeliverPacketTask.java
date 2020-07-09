package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DeliverPacketTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO: define message
		throw new BpmnError("499");
	}

}