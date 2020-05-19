package edu.thi.flytransport.messaging.servicetask;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.messaging.beans.Order;

public class GetCredentialsTask implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String username = (String) execution.getVariable("username");
		String password = (String) execution.getVariable("password");
		Long packetLength = (Long) execution.getVariable("packetLength");
		Long packetWidth = (Long) execution.getVariable("packetWidth");
		Long packetHeight = (Long) execution.getVariable("packetHeight");
		Long packetWeight = (Long) execution.getVariable("packetWeight");
		
		Order order = new Order(username,password,packetLength,packetWidth,packetHeight,packetWeight);
		execution.setVariable("order", order);
		execution.setVariable("gotCredentials", true);
	}
}
