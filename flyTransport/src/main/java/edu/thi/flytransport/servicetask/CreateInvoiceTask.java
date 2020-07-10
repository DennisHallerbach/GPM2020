package edu.thi.flytransport.servicetask;
/**
 * Author: Julian Bauer
 */

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.beans.Drone;
import edu.thi.flytransport.beans.Invoice;
import edu.thi.flytransport.beans.Order;

public class CreateInvoiceTask implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Order order = (Order) execution.getVariable("order");
		
		Drone drone = (Drone) execution.getVariable("drone");
		
		Invoice invoice = new Invoice(order.getOrderid());
		invoice.setSum(drone.getClazz().getPrice());
		
		execution.setVariable("invoice",invoice);
	}

}
