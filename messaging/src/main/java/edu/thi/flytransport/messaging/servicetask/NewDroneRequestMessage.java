package edu.thi.flytransport.messaging.servicetask;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;


public class NewDroneRequestMessage implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String Username = (String) execution.getVariable("username");
		String Password = (String) execution.getVariable("password");
		Long packetLength = (Long) execution.getVariable("packetLength");
		Long packetWidth = (Long) execution.getVariable("packetWidth");
		Long packetHeight = (Long) execution.getVariable("packetHeight");
		Long packetWeight = (Long) execution.getVariable("packetWeight");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("username", Username);
		data.put("password", Password);
		data.put("packetLength", packetLength);
		data.put("packetWidth", packetWidth);
		data.put("packetHeight", packetHeight);
		data.put("packetWeight", packetWeight);
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        MessageCorrelationResult mcresult = runtimeService.createMessageCorrelation("NewDroneRequestMessage")
                                                            .setVariables(data)
                                                            .correlateWithResult();
        
        System.out.println(mcresult);
		
	}

}