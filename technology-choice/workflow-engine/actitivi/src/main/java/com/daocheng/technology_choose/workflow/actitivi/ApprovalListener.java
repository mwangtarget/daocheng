package com.daocheng.technology_choose.workflow.actitivi;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 
 * after clicking approve/reject we should do some actions such as sending email...
 *those actions will be handled here
 *
 */
public class ApprovalListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask arg0) {
		System.out.println("Task Completed Listener: " + arg0.getTaskDefinitionKey());
		System.out.println("Email sent!");
		
	}

	
	
}
