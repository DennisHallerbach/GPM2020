package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NoDroneAvailableMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String correlationId = (String) execution.getVariable("correlationId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("NoDroneAvailableMessage")
			.processInstanceVariableEquals("processId", correlationId)
            .correlateWithResult();
	}

}