package com.daocheng.technology_choose.workflow.actitivi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * The sample to Start Engine and tasks and act on it
 *
 */
public class ActivitiEngine 
{
	public static void main(String[] args) {
		// START--load process definition to engine
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		repositoryService.createDeployment()
				.addClasspathResource("diagrams/TicketRequest.bpmn20.xml")
				.deploy();
		System.out.println("Number of process definitions: "
				+ repositoryService.createProcessDefinitionQuery().count());
		// END--load process definition to engine
		System.out.println("-------------------------------------------------");
		// submit and approve
		ActivitiEngine.submitAndApprove(processEngine);
		System.out.println("-------------------------------------------------");
		// submit and reject
		ActivitiEngine.submitAndReject(processEngine);
	}

	private static void submitAndApprove(ProcessEngine processEngine) {
		// create ticket for approval
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("ticketId", "POS001");
		variables.put("assigneeName", "Pig Pig");
		// start the task
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("ticketRequest", variables);
		// list pending tasks for this process
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery()
				.taskCandidateGroup("management").list();
		for (Task task : tasks) {
			System.out.println("Task available: " + task.getName());
		}

		Task task = tasks.get(0);
		System.out.println("Task Description: " + task.getDescription());
		Map<String, Object> taskVariables = new HashMap<String, Object>();
		taskVariables.put("ticketApproved", "true");
		taskVariables.put("managerMotivation", "Qualified poster!");
		taskService.complete(task.getId(), taskVariables);
		// should be NO pending task
		System.out.println("Task available: "
				+ taskService.createTaskQuery()
						.taskCandidateGroup("management").list().size());

	}
	
	private static void submitAndReject(ProcessEngine processEngine) {
		// create ticket for approval
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("ticketId", "POS002");
		variables.put("assigneeName", "Yo Yo");
		// start the task
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("ticketRequest", variables);
		// list pending tasks for this process
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery()
				.taskCandidateGroup("management").list();
		for (Task task : tasks) {
			System.out.println("Task available: " + task.getName());
		}

		Task task = tasks.get(0);
		System.out.println("Task Description: " + task.getDescription());
		Map<String, Object> taskVariables = new HashMap<String, Object>();
		taskVariables.put("ticketApproved", "false");
		taskVariables.put("managerMotivation", "Not qualified poster!");
		taskService.complete(task.getId(), taskVariables);
		// list out pending task
		System.out.println("Task available: "
				+ taskService.createTaskQuery().processVariableValueEquals("ticketId", "POS002").list().get(0).getName());
		System.out.println("Task description: "
				+ taskService.createTaskQuery().processVariableValueEquals("ticketId", "POS002").list().get(0).getDescription());
	}
}
