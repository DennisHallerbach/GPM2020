package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PacketPickedUpMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String userProcessId = (String) execution.getVariable("userProcessId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("PacketPickedUpMessage")
				.processInstanceVariableEquals("processId", userProcessId).correlate();
	}

}