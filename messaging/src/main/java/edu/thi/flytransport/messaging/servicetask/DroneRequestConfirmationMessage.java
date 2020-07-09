package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.messaging.beans.Order;

public class DroneRequestConfirmationMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String correlationId = (String) execution.getVariable("correlationId");
		Order order = (Order) execution.getVariable("order");
		String orderInfo = String.format("Bestellung mit %s wurde erfolgreich erstellt, bitte bestätigen Sie den Auftrag.", order.getOrderid());
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("DroneRequestConfirmationMessage")
			.processInstanceVariableEquals("processId", correlationId)
			.setVariable("correlationId", execution.getVariable("processId"))
			.setVariable("orderInfo", orderInfo)
            .correlateWithResult();
	}

}