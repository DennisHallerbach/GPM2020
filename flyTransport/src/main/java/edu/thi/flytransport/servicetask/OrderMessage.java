package edu.thi.flytransport.servicetask;
/**
 * Author: Dennis Hallerbach
 */

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class OrderMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String correlationId = (String) execution.getVariable("correlationId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("OrderMessage")
			.processInstanceVariableEquals("processId", correlationId)
			.setVariable("correlationId", execution.getVariable("processId"))
            .correlateWithResult();        
	}

}