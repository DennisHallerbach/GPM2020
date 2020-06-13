package edu.thi.flytransport.messaging.servicetask;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class DroneRequestConfirmationMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String processId = (String) execution.getVariable("processId");
		String userProcessId = (String) execution.getVariable("userProcessId");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("deliveryProcessId",processId);
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        MessageCorrelationResult mcresult = runtimeService.createMessageCorrelation("DroneRequestConfirmMessage")
        													.processInstanceVariableEquals("processId", userProcessId)
                                                            .setVariables(data)
                                                            .correlateWithResult();
	}

}