package com.daocheng.trade;

import static spark.Spark.*;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;
import com.daocheng.common.DBUtil;

import org.bson.Document;
import org.joda.beans.Bean;
import org.joda.beans.ser.JodaBeanSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TradeAPIServerSpark {

	static Logger logger = LoggerFactory.getLogger(TradeAPIServerSpark.class);
	
	public static void main(String[] args) {

		
		get("/trade/:tradeid", (request, response) -> {
			
			FindIterable<Document> iterable  =  DBUtil.getDBConnection().getCollection("trade").find(new Document("info.id", "trade~" + request.params(":tradeid")));
			
			StringBuilder tradeJsonBuilder = new StringBuilder();
			iterable.forEach(new Block<Document>() {
			    @Override
			    public void apply(final Document document) {
			    	String tradeJson = JSON.serialize(document);
			    	tradeJsonBuilder.append(tradeJson);
			    }
			});

			return tradeJsonBuilder.toString();
		});

		post("/trade", (request, response) -> {
			
			String tradeDetail  = request.body();
			
			Bean tradeBean = JodaBeanSer.PRETTY.jsonReader().read(tradeDetail);
			logger.debug("Receiving Trade type: "+ tradeBean.getClass());
			
			logger.debug("Save the trade");

			Document dbObject=  Document.parse(tradeDetail);
			DBUtil.getDBConnection().getCollection("trade").insertOne(dbObject);

			return true;
		});

	}
}
