package com.daocheng.technology_choose.tm.spring_atomikos;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

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
public class ProgramicUserTransactionSpring2 {

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
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		TransactionStatus status = txnManager.getTransaction(new DefaultTransactionDefinition());
		Connection con;

		try {
			con = dataSource.getConnection();
			con.createStatement()
					.executeUpdate(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)",
							"USD/INR", Double.toString(20.5)));
			con.createStatement()
					.executeUpdate(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)",
							"USD/SGD", Double.toString(2.08)));
			txnManager.rollback(status); // When rollback, count is 2,why?
			// txnManager.commit(status); // when commit, count is 2;
			
			ResultSet rs = con.createStatement().executeQuery("select count(*) from MARKET_DATA_EOD_TX");
			while (rs.next()) {
				logger.info("Number of records in MARKET_DATA_EOD_TX:" + rs.getString(1));
			}

			
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
