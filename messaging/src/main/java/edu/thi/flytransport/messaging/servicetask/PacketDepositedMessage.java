package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PacketDepositedMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String deliveryProcessId = (String) execution.getVariable("deliveryProcessId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("PacketPickedUpMessage")
				.processInstanceVariableEquals("processId", deliveryProcessId).correlate();
	}

}