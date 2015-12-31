package com.daocheng.technology_choose.batch.spring_batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class DBItemWriter implements ItemWriter<MarketData>{

	private MarketDataDAO mdDAO;
	


	public void setMdDAO(MarketDataDAO mdDAO) {
		this.mdDAO = mdDAO;
	}



	@Override
	public void write(List<? extends MarketData> mdOut) throws Exception {
	    mdOut.forEach(x ->mdDAO.saveMarketData(x) );
	}
	
	
}
