package com.daocheng.technology_choose.batch.spring_batch;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.common.io.Files;

public class MarketDataDAO {

	private DataSource dataSource;
	private Resource insertSQL;

	public void setInsertSQL(Resource insertSQL) {
		this.insertSQL = insertSQL;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	public void saveMarketData(MarketData marketData) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String strSQL = null;
		try {
			strSQL = Files.toString(insertSQL.getFile(), Charset.defaultCharset());
		} catch (IOException e) {
			// Ignore
			e.printStackTrace();
		}
		
		jdbcTemplate.update(strSQL, new Object[] { marketData.getInstrument(), marketData.getPrice(),
				Date.valueOf(marketData.getClosingDate()), marketData.getXmlData() });
	}

}
