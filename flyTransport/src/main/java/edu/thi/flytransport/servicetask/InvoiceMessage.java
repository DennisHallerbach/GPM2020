package edu.thi.flytransport.servicetask;
/**
 * Author: Julian Bauer
 */

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.beans.Invoice;

public class InvoiceMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Invoice invoice = (Invoice) execution.getVariable("invoice");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("invoiceNr", String.format("%s", invoice.getInvoiceId()));
		data.put("invoiceAmount", String.format("%s €", invoice.getSum()));
		data.put("invoiceDescription", invoice.getDescription());
		
		String correlationId = (String) execution.getVariable("correlationId");
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("InvoiceMessage")
			.processInstanceVariableEquals("processId", correlationId)
			.setVariables(data)
			.setVariable("correlationId", execution.getVariable("processId"))
            .correlateWithResult();
	}

}