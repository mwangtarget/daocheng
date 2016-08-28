package com.daocheng.trade.controller;

import org.joda.beans.ser.JodaBeanSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daocheng.clearout.ResponseBean;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

//TODO: define a more meaningful Request/Response
@RestController
public class TradeController {

	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(value = "/trade/{tradeId}", method = RequestMethod.GET)
	public ResponseBean getTrade(@PathVariable(value="tradeId") String tradeId) {
		
		//TODO: change trade~ with an enum
		BasicDBObject dbObject = (BasicDBObject)mongoTemplate.getCollection("trade").findOne(new BasicDBObject("info.id", "trade~"+tradeId));
		
		dbObject.removeField("_id");
		String tradeJson = JSON.serialize(dbObject);
		
//		T jodaBean = JodaBeanSer.PRETTY.jsonReader().read(tradeJson, beanType);
		
		String jodaBeanClass = dbObject.getString("@bean");
		return new ResponseBean(jodaBeanClass, tradeJson);
	}

	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	public void saveTrade(RequestEntity<String> requestEntity) {
	        System.out.println("request body : " + requestEntity.getBody());
	        HttpHeaders headers = requestEntity.getHeaders();
	        System.out.println("request headers : " + headers);
	        HttpMethod method = requestEntity.getMethod();
	        System.out.println("request method : " + method);
	}
	
}
