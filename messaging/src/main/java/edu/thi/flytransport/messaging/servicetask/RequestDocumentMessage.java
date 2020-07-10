package edu.thi.flytransport.messaging.servicetask;
/**
 * Author: Dennis Hallerbach
 */

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RequestDocumentMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String correlationId = (String) execution.getVariable("correlationId");
		String documenttext = (String)execution.getVariable("text");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("RequestDocumentMessage")
			.processInstanceVariableEquals("processId", correlationId)
			.setVariable("correlationId", execution.getVariable("processId"))
			.setVariable("documenttext", documenttext)
            .correlateWithResult();
	}

}