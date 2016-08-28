package com.daocheng.clearout;

import static com.opengamma.strata.basics.currency.Currency.GBP;
import static com.opengamma.strata.basics.currency.Currency.USD;

import java.time.LocalDate;

import org.joda.beans.ser.JodaBeanSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.opengamma.strata.basics.StandardId;
import com.opengamma.strata.basics.currency.CurrencyAmount;
import com.opengamma.strata.basics.currency.FxRate;
import com.opengamma.strata.product.Trade;
import com.opengamma.strata.product.TradeAttributeType;
import com.opengamma.strata.product.TradeInfo;
import com.opengamma.strata.product.fx.FxSingle;
import com.opengamma.strata.product.fx.FxSingleTrade;

@SpringBootApplication
public class TradeAPISever implements CommandLineRunner {

	// Restlet Main
	// public static void main(String[] args) throws Exception{
	// Component component = new Component();
	// component.getServers().add(Protocol.HTTP, 8182);
	//
	// //Attach Restful resource
	// component.getDefaultHost().attach("/tradeapi", TradeAPIRest.class);
	//
	// // Start application
	// component.start();
	// }

	@Autowired
	MongoTemplate mongoTemplate;

	// Spring Boot Main
	public static void main(String[] args) {
		SpringApplication.run(TradeAPISever.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		mongoTemplate.getCollection("trade").save(new BasicDBObject("a", "b"));

		FxSingle fx = FxSingle.of(CurrencyAmount.of(GBP, 10000), FxRate.of(GBP, USD, 1.62), LocalDate.of(2014, 9, 14));
		FxSingleTrade fxSingleTrade = FxSingleTrade.builder().product(fx)
				.info(TradeInfo.builder().id(StandardId.of("trade", "1"))
						.addAttribute(TradeAttributeType.DESCRIPTION, "GBP 10,000/USD @ 1.62 fwd")
						.counterparty(StandardId.of("example", "BigBankA")).settlementDate(LocalDate.of(2014, 9, 15))
						.build())
				.build();

		BasicDBObject fxSingleTradeDocument = BasicDBObject.parse(JodaBeanSer.PRETTY.jsonWriter().write(fxSingleTrade));
		mongoTemplate.getCollection("trade").save(fxSingleTradeDocument);

		
		DBCursor cursor = mongoTemplate.getCollection("trade").find(new BasicDBObject("info.id", "trade~1"));
		while(cursor.hasNext()){
			BasicDBObject dbObject = (BasicDBObject)cursor.next();		
			dbObject.removeField("_id");
			String fullJason = JSON.serialize(dbObject);
			
			//Get the joda bean Class name
			String jodaBeanClass = dbObject.getString("@bean");
			
			Class beanClass = Class.forName(jodaBeanClass);
			
			System.out.println(JodaBeanSer.PRETTY.jsonReader().read(fullJason, beanClass));

		}
		
	}
}
