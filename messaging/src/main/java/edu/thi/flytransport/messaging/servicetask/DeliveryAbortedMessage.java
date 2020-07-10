package edu.thi.flytransport.messaging.servicetask;
/**
 * Author: Julian Bauer
 */

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DeliveryAbortedMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String correlationId = (String) execution.getVariable("correlationId");
		String errorMessage = (String) execution.getVariable("errorDuringDelivery");
		String messageFromFlyTransport = (String) execution.getVariable("messageForCustomer");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("DeliveryAbortedMessage")
			.processInstanceVariableEquals("processId", correlationId)
			.setVariable("correlationId", execution.getVariable("processId"))
			.setVariable("errorMessage", errorMessage)
			.setVariable("messageFromFlyTransport", messageFromFlyTransport)
            .correlateWithResult();
	}

}