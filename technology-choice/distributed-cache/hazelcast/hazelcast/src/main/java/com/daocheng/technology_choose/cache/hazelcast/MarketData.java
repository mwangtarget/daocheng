package com.daocheng.technology_choose.cache.hazelcast;

import java.io.Serializable;

/**
 * A market Data class that can be a good candidate of Caching.
 * @author mwang
 *
 */
public class MarketData implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String instrument;
	private double marketPrice;
	private boolean isLive;
	
	
	public String getInstrument() {
		return instrument;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public boolean isLive() {
		return isLive;
	}

	private MarketData(String instrument, double marketPrice, boolean isLive){
		this.instrument = instrument;
		this.marketPrice = marketPrice;
		this.isLive = isLive;
	}

	public static class Builder {
		private String instrument;
		private double marketPrice;
		private boolean isLive;
		
		public Builder instrument(String instrument){
			this.instrument = instrument;
			return this;
		}
		public Builder marketPrice(double marketPrice){
			this.marketPrice = marketPrice;
			return this;
		}
		public Builder isLive(boolean isLive){
			this.isLive = isLive;
			return this;
		}
		
		public MarketData build(){
			return new MarketData(this.instrument, this.marketPrice, this.isLive);
		}
		
	}

	@Override
	public String toString() {
		return "MarketData [instrument=" + instrument + ", marketPrice=" + marketPrice + ", isLive=" + isLive + "]";
	}
	
}
