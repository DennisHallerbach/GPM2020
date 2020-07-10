package edu.thi.flytransport.tasklistener;

/**
 * Author: Dennis Hallerbach
 * Vorlage: Skript
 */

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.impl.TaskServiceImpl;
import org.camunda.bpm.engine.impl.interceptor.CommandExecutorImpl;

public class SkipTask implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		if((Boolean) delegateTask.getExecution().getVariable("completionCondition")) {
			TaskServiceImpl taskService = new TaskServiceImpl();
			taskService.setCommandExecutor(new CommandExecutorImpl());;
			this.finishCurrentTask(taskService,delegateTask);
		}
	}

	private void finishCurrentTask(TaskServiceImpl taskService, DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		taskService.complete((delegateTask.getId()));
	}

}
