package edu.thi.flytransport.servicetask;
/**
 * Author: Dennis Hallerbach
 */

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class NewDroneRequestMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String Username = (String) execution.getVariable("username");
		String Password = (String) execution.getVariable("password");
		Long packetLength = (Long) execution.getVariable("packetLength");
		Long packetWidth = (Long) execution.getVariable("packetWidth");
		Long packetHeight = (Long) execution.getVariable("packetHeight");
		Long packetWeight = (Long) execution.getVariable("packetWeight");
		Long age = (Long) execution.getVariable("age");
		Long userAge = (Long) execution.getVariable("userAge");
		String dangerous = (String) execution.getVariable("dangerous");
		String destination = (String) execution.getVariable("destination");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("username", Username);
		data.put("password", Password);
		data.put("packetLength", packetLength);
		data.put("packetWidth", packetWidth);
		data.put("packetHeight", packetHeight);
		data.put("packetWeight", packetWeight);
		data.put("age", age);
		data.put("userAge", userAge);
		data.put("dangerous", dangerous);
		data.put("destination",destination);
		
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        runtimeService.createMessageCorrelation("NewDroneRequestMessage")
                                                            .setVariables(data)
                                                            .setVariable("correlationId",execution.getVariable("processId"))
                                                            .correlateWithResult();
		
	}

}