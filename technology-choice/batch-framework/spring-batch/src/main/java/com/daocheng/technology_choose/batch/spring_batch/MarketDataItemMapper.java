package com.daocheng.technology_choose.batch.spring_batch;

import java.time.LocalDate;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
/**
 * A mapper to map from raw String to Object
 * @author mwang
 *
 */
public class MarketDataItemMapper implements FieldSetMapper<MarketData>{

	@Override
	public MarketData mapFieldSet(FieldSet fieldSet) throws BindException {
	
		String instrument = fieldSet.readString(0);
		double price = fieldSet.readDouble(1);
	    String dateStr = fieldSet.readString(2);
	    String[] dateStrSp=dateStr.split("-");
	    LocalDate date = LocalDate.of(Integer.parseInt(dateStrSp[0]), Integer.parseInt(dateStrSp[1]), Integer.parseInt(dateStrSp[2]));
	    
		MarketData md = new MarketData();
		md.setInstrument(instrument);
		md.setPrice(price);
		md.setClosingDate(date);
		
		return md;
	    
	}

}
