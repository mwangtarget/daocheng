package com.daocheng.technology_choose.communication.resful_spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TradeDAO {
	
	private static List<Trade> tradeList = new ArrayList<>();
	
	public static void addTrade(Trade trade){
		tradeList.add(trade);
	}
	
	public static void addTrades(Trade ... trades){
	    tradeList.addAll(Arrays.asList(trades));
	}
	
	public static void deleteTrade(int tradeId){
		tradeList.removeIf(x -> x.getTradeId() == tradeId);
	}
	
	public static void deleteTrades(Integer ... tradeIds){	
		Arrays.asList(tradeIds).stream().forEach(x-> {
		    tradeList.removeIf(y-> y.getTradeId() == x.intValue());
		});
	}
	
	public static Trade getTrade(int tradeId){
		Trade returnTrade = null;
		
		try{ 
				
			returnTrade = tradeList.stream()
				        .filter(x-> x.getTradeId() == tradeId)
				        .findFirst().get();
		} catch (java.util.NoSuchElementException ne){
			return null;
		}
		
		return returnTrade;
	}
	
	public  static Trade[] getTrades(Integer ... tradeIds){
		 List<Trade> returnTrades = new ArrayList<>();
		 Arrays.asList(tradeIds).stream().forEach(x -> {
			 returnTrades.add(
					 tradeList.stream()
					 .filter(y -> y.getTradeId() == x.intValue())
					 .findFirst().get());
		 });
		 
		 return (Trade[])returnTrades.toArray();
	}
	
	
	
	

}
