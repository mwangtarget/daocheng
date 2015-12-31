package com.daocheng.technology_choose.batch.spring_batch;

import java.time.LocalDate;

/**
 * Not a builder pattern this time to save the time
 * @author mwang
 *
 */
public class MarketData {

	private String instrument;
	private double price;
	private LocalDate closingDate;
	private String xmlData;
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}
	public String getXmlData() {
		return xmlData;
	}
	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}
	
	
}
