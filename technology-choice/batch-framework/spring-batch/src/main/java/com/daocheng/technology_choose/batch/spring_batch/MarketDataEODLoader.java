package com.daocheng.technology_choose.batch.spring_batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A usage of Spring batch to load a CSV file then transform to XML, then write
 * to H2DB.
 * 
 * Load EOD market data rates
 *
 */
public class MarketDataEODLoader {
	final static Logger logger = LoggerFactory.getLogger(MarketDataEODLoader.class);

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		logger.info("Initializing Spring context.");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context_all.xml");

		logger.info("Spring context initialized.");
		
		// Initialize Job
		JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
		Job job = (Job) applicationContext.getBean("spotMarketDataJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			logger.info("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			//Ignore
			e.printStackTrace();
		}

		
	}
}
