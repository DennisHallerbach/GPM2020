package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class NoDroneAvailableMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String userProcessId = (String) execution.getVariable("userProcessId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("NoDroneAvailableMessage")
				.processInstanceVariableEquals("processId", userProcessId).correlate();
	}

}