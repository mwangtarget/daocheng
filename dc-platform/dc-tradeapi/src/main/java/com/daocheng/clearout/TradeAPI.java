package com.daocheng.clearout;


import com.opengamma.strata.basics.StandardId;
import com.opengamma.strata.product.Trade;

public interface TradeAPI {
	
	public void createTrade(Trade trade);
	
	public void deleteTrade(Trade trade);
	
	public String getLatestTrade(StandardId tradeId);

}
