package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.messaging.UserProvider;
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
		
		boolean gotCredentials = UserProvider.findUser(username);
		
        if(gotCredentials){
    		execution.setVariable("gotCredentials", gotCredentials);
    		Order order = new Order(username,packetLength,packetWidth,packetHeight,packetWeight);
    		execution.setVariable("order", order);
        } else {
    		execution.setVariable("gotCredentials", gotCredentials);        	
        }
	}
}
