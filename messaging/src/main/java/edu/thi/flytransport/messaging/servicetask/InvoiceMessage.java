package edu.thi.flytransport.messaging.servicetask;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InvoiceMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String invoiceNr = (String) execution.getVariable("invoiceNr");
		String invoiceAmount = (String) execution.getVariable("invoiceAmount");
		String invoiceDescription = (String) execution.getVariable("invoiceDescription");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("invoiceNr", invoiceNr);
		data.put("invoiceAmount", invoiceAmount);
		data.put("invoiceDescription", invoiceDescription);
		String userProcessId = (String) execution.getVariable("userProcessId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("InvoiceMessage").setVariables(data)
				.processInstanceVariableEquals("processId", userProcessId).correlate();
	}

}