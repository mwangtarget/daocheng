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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DeclaritiveTransactionSpring {

	final static Logger logger = LoggerFactory.getLogger(DeclaritiveTransactionSpring.class);

	public static void main(String[] args) {

		logger.info("Initializing Spring context.");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context_all.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		saveMarketData(jdbcTemplate);
		
		logger.info("Spring context initialized.");
		
		try {
			Connection con = ((DataSource)applicationContext.getBean("dataSource")).getConnection();
			ResultSet rs = con.createStatement().executeQuery("select count(*) from MARKET_DATA_EOD_TX");
			while (rs.next()) {
				logger.info("Number of records in MARKET_DATA_EOD_TX:" + rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public static void saveMarketData(JdbcTemplate jdbcTemplate) {
		jdbcTemplate.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/INR",
				Double.toString(20.5)));
		jdbcTemplate.execute(format("insert into MARKET_DATA_EOD_TX (instrument, price) values('%s', %s)", "USD/SGD",
				Double.toString(2.08)));
	}

}
