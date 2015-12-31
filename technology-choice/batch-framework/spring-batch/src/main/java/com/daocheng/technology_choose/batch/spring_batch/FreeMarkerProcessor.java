package com.daocheng.technology_choose.batch.spring_batch;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import freemarker.template.Template;

/**
 * A processor to add the XML part of MarketData Object based on FreeMarker
 * @author mwang
 *
 */
public class FreeMarkerProcessor implements ItemProcessor<MarketData, MarketData>{

	private FreeMarkerTemplate template;
	
	@Override
	public MarketData process(MarketData mdIn) throws Exception {
		Map<String, Object> mapIn = new HashMap<>();
		mapIn.put("md", mdIn);
		
		StringWriter strWr = new StringWriter();
		template.getTemplate().process(mapIn, strWr);
		
		String xmlData = strWr.getBuffer().toString();
		mdIn.setXmlData(xmlData);
		
		//This better to return a new MarketData for concurrency concern
		return mdIn;
	}
	
	// For inject into the FreeMarket template
	public void setTemplate(FreeMarkerTemplate freeMarkerTemplate){
		template = freeMarkerTemplate;
	}

}
