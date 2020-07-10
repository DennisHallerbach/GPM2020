package edu.thi.flytransport.servicetask;
/**
 * Author: Dennis Hallerbach
 */

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.UserProvider;

public class CheckCredentialsTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String username = (String) execution.getVariable("username");
		String password = (String) execution.getVariable("password");
		boolean verified = UserProvider.checkPassword(username, password);
		execution.setVariable("verified", verified);
	}

}
