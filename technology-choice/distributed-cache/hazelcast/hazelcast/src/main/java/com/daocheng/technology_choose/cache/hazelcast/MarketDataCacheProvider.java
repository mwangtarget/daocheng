package com.daocheng.technology_choose.cache.hazelcast;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

/**
 * A Library Client for the MarketDataCache Server
 * 
 * @author mwang
 *
 */
public class MarketDataCacheProvider {
	private final static String MDT_CACHE = "marketdata";

	public static void main(String[] args) {

		// Client to server configuration.
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getNetworkConfig().addAddress("127.0.0.1");

		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

		Map<String, MarketData> marketDataCache = client.getMap(MDT_CACHE);

		// Put some entries in
		// Filled up Initial marketData
		MarketData md1 = new MarketData.Builder().instrument("GBP/USD").marketPrice(1.05).isLive(true).build();
		MarketData md2 = new MarketData.Builder().instrument("USD/CNY").marketPrice(6.55).isLive(true).build();
		marketDataCache.put(md1.getInstrument(), md1);
		marketDataCache.put(md2.getInstrument(), md2);

		marketDataCache.entrySet().stream().forEach(e -> {
			System.out.println(e.getValue());
		});
		;

		System.out.println("Sleep for 3 seconds");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e1) {
			// Can Ignore
			e1.printStackTrace();
		}

		marketDataCache.entrySet().stream().forEach(e -> {
			System.out.println(e.getValue());
		});
		;

	}
}
