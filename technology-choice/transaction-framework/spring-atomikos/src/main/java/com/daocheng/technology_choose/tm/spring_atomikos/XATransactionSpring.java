package com.daocheng.technology_choose.tm.spring_atomikos;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class XATransactionSpring {

	final static Logger logger = LoggerFactory.getLogger(DeclaritiveTransactionSpring.class);

	public static void main(String[] args) {

		logger.info("Initializing Spring context.");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context_xa_all.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		JdbcTemplate jdbcTemplate2 = (JdbcTemplate) applicationContext.getBean("jdbcTemplate2");
		try {
			saveMarketData(jdbcTemplate, jdbcTemplate2);
		} catch (Exception e) {
			// Only to Test the rollback scenarios.
			e.printStackTrace();
		}
		logger.info("Spring context initialized.");

		try {
			Connection con = ((DataSource) applicationContext.getBean("dataSource")).getConnection();
			ResultSet rs = con.createStatement().executeQuery("select count(*) from MARKET_DATA_EOD_TX");
			while (rs.next()) {
				logger.info("Number of records in MARKET_DATA_EOD_TX of H2_First:" + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = ((DataSource) applicationContext.getBean("dataSource2")).getConnection();
			ResultSet rs = con.createStatement().executeQuery("select count(*) from MARKET_DATA_EOD_TX");
			while (rs.next()) {
				logger.info("Number of records in MARKET_DATA_EOD_TX of H2_Second:" + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Seems add transactional annotation is not working
	@Transactional
	public static void saveMarketData(JdbcTemplate jdbcTemplate, JdbcTemplate jdbcTemplateHSQL) {
		jdbcTemplate.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/INR",
				Double.toString(20.5)));
		jdbcTemplate.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/SGD",
				Double.toString(2.08)));
		
		jdbcTemplateHSQL.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/INR",
				Double.toString(20.5)));
		jdbcTemplateHSQL.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/SGD",
				Double.toString(2.08)));
	
		if (true)
			throw new RuntimeException("Throw Exception");
	}

}
