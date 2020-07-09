package edu.thi.flytransport.messaging.servicetask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import edu.thi.flytransport.messaging.beans.Drone;
import edu.thi.flytransport.messaging.beans.Invoice;
import edu.thi.flytransport.messaging.beans.Order;

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
