package com.daocheng.technology_choose.tm.spring_atomikos;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * The programatic way of utilize the Transaction support from Spring. -> Seems
 * not working
 * 
 * @author mwang
 *
 */
public class ProgramicUserTransactionSpring {

	final static Logger logger = LoggerFactory.getLogger(ProgramicUserTransactionSpring.class);

	/**
	 * Main method.
	 */
	public static void main(String[] args) {

		logger.info("Initializing Spring context.");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context_all.xml");

		logger.info("Spring context initialized.");

		DataSourceTransactionManager txnManager = (DataSourceTransactionManager) applicationContext
				.getBean("transactionManager");				
		TransactionStatus status = txnManager.getTransaction(new DefaultTransactionDefinition());

		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		jdbcTemplate.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/INR",
				Double.toString(20.5)));
		jdbcTemplate.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/SGD",
				Double.toString(2.08)));

		
		txnManager.rollback(status); // When rollback, count is 0;
//		 txnManager.commit(status); // when commit, count is 2;

		try {
			Connection con = txnManager.getDataSource().getConnection();
			ResultSet rs = con.createStatement().executeQuery("select count(*) from MARKET_DATA_EOD_TX");
			while (rs.next()) {
				logger.info("Number of records in MARKET_DATA_EOD_TX:" + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
