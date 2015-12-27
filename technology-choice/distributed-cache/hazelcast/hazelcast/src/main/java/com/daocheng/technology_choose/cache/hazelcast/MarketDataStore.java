package com.daocheng.technology_choose.cache.hazelcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static java.lang.String.format;
import com.hazelcast.core.MapStore;

/**
 * 
 * A message store layer between cache and H2 database storage
 */
public class MarketDataStore implements MapStore<String, MarketData>{

    Connection conn  = null;
    public MarketDataStore() {
        try {
           Class.forName("org.h2.Driver");
           conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
           conn.createStatement().executeUpdate(
                    "create table if not exists MarketData (instrument varchar(10), marketprice double, islive boolean)");
        } catch (Exception e) {
        	// Ignore for now.
            throw new RuntimeException(e);
        }
    }

    public synchronized void delete(String key) {
        System.out.println("Delete:" + key);
        try {
        	conn.createStatement().executeUpdate(format("delete from MarketData where instrument = %s", key));
        } catch (SQLException e) {
        	// Ignore for now.
            throw new RuntimeException(e);
        }
    }

    public synchronized void store(String key, MarketData value) {
        try {
        	conn.createStatement().executeUpdate(
                    format("insert into MarketData values('%s', %s, %s)", key, Double.toString(value.getMarketPrice()), Boolean.toString(false)));
        } catch (SQLException e) {
        	// Ignore for now.
            throw new RuntimeException(e);
        }
    }

    public synchronized void storeAll(Map<String, MarketData> map) {
        for (Map.Entry<String, MarketData>  entry : map.entrySet())
            store(entry.getKey(), entry.getValue());
    }

    public synchronized void deleteAll(Collection<String> keys) {
        for (String key : keys) delete(key);
    }
    
    public synchronized MarketData load(String key) {
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(
                    format("select instrument, marketprice, islive from MarketData where instrument ='%s'", key));
            try {
                if (!resultSet.next()) return null;
                String instrument = resultSet.getString(1);
                double marketPrice = resultSet.getDouble(2);
                boolean isLive = resultSet.getBoolean(3);
                return new MarketData.Builder().instrument(instrument).marketPrice(marketPrice).isLive(isLive).build();
            } finally {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized Map<String, MarketData> loadAll(Collection<String> keys) {
        Map<String, MarketData> result = new HashMap<>();
        for (String key : keys) result.put(key, load(key));
        return result;
    }

	@Override
	public Iterable<String> loadAllKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
