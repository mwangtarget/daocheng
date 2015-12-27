package com.daocheng.technology_choose.cache.hazelcast;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * The HazelCast server member.
 * 
 * there are two type of deployment of HazelCast:
 * 1. Share the same heap with the application(aka, Client)
 * 2. Operate in a separate serve or process (like Redis, memcached)
 * 
 * -> 2 is better
 * 
 * * The member should handle the Cache & Persistence logic.
 * 1. How often to put into Storage.
 * 2. How to handle the sync between different Cache.
 * 
 * @author mwang
 *
 */
public class CacheServerMemeber {
	
	private final static String MDT_CACHE="marketdata";
	
	public static void main(String[] args){
		// Some programming way of configuration
		Config cfg = new Config(); 
		MapConfig mapCfg = new MapConfig();
		mapCfg.setName(MDT_CACHE);
		mapCfg.setBackupCount(1);
		mapCfg.getMaxSizeConfig().setSize(3);
		mapCfg.setTimeToLiveSeconds(3);
		
		MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setImplementation(new com.daocheng.technology_choose.cache.hazelcast.MarketDataStore());//The classpath need to be full name**
        mapStoreConfig.setWriteDelaySeconds(0);
        mapStoreConfig.setEnabled(true);
        mapCfg.setMapStoreConfig(mapStoreConfig);
        
		cfg.addMapConfig(mapCfg);
		       
		
		HazelcastInstance memberInstance = Hazelcast.newHazelcastInstance(cfg);
		
		IMap<String, MarketData> marketDataCache = memberInstance.getMap(MDT_CACHE);
		
		//Filled up Initial marketData
		MarketData md1 = new MarketData.Builder().instrument("EUR/USD").marketPrice(1.05).isLive(true).build();
		MarketData md2 = new MarketData.Builder().instrument("USD/CNH").marketPrice(6.55).isLive(true).build();
		marketDataCache.put(md1.getInstrument(), md1);
		marketDataCache.put(md2.getInstrument(), md2);
		
//		marketDataCache.evictAll();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e1) {
			// Can Ignore
			e1.printStackTrace();
		}


		//Filled up Initial marketData
		MarketData md3 = new MarketData.Builder().instrument("USD/SGD").marketPrice(1.05).isLive(true).build();
		MarketData md5 = new MarketData.Builder().instrument("USD/INR").marketPrice(6.55).isLive(true).build();
		marketDataCache.put(md1.getInstrument(), md3);
		marketDataCache.put(md2.getInstrument(), md5);
	}

}
