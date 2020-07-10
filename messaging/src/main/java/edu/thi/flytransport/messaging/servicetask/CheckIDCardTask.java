package edu.thi.flytransport.messaging.servicetask;
/**
 * Author: Dennis Hallerbach
 */

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckIDCardTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		execution.setVariable("IDCardCheck", true);
		execution.setVariable("AgeOK", true);
	}

}