package com.daocheng.technology_choose.tm.spring_atomikos;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Use the underlying DB to control the transaction.
 * 
 * The transaction are managed by DB .
 *
 */
public class LocalTransactionPattern {
	
	public static void main(String[] args) {
		Connection conn;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			
			conn.setAutoCommit(false);
			
			conn.createStatement().executeUpdate(format("insert into MarketData values('%s', %s, %s)", "USD/INR", Double.toString(20.5), Boolean.toString(false)));
			conn.createStatement().executeUpdate(format("insert into MarketData values('%s', %s, %s)", "USD/SGD", Double.toString(2.08), Boolean.toString(false)));
			
			conn.commit();
			
			conn.close();
		} catch (Exception e) {
			// Ingore
			e.printStackTrace();
		}

	}
}
