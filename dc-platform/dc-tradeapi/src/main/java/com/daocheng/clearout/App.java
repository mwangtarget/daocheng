package com.daocheng.clearout;

import static com.opengamma.strata.basics.currency.Currency.GBP;
import static com.opengamma.strata.basics.currency.Currency.USD;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.joda.beans.Bean;
import org.joda.beans.integrate.mongo.BeanMongoDBObject;
import org.joda.beans.ser.JodaBeanSer;

import com.google.common.collect.ImmutableMap;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;
import com.opengamma.strata.basics.StandardId;
import com.opengamma.strata.basics.currency.CurrencyAmount;
import com.opengamma.strata.basics.currency.FxRate;
import com.opengamma.strata.product.Trade;
import com.opengamma.strata.product.TradeAttributeType;
import com.opengamma.strata.product.TradeInfo;
import com.opengamma.strata.product.fx.FxSingle;
import com.opengamma.strata.product.fx.FxSingleTrade;

public class App {
	public static void main(String[] args) {
		System.out.println("Test Entry program");
//		saveTransaction();
	}

	/**
	 * public static void saveTransaction() {
	 

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("dc-transaction");
		DBCollection coll = db.getCollection("transaction");

		FxSingle fx = FxSingle.of(CurrencyAmount.of(GBP, 10000), FxRate.of(GBP, USD, 1.62), LocalDate.of(2014, 9, 14));
		Transaction fxTransaction = Transaction.builder().id(StandardId.of("transactionID", "DC123456"))
				.bookInfo(BookInfo.builder().id(StandardId.of("portfolio", "GBL_G10_SPT")).build())
				.partyInfo(PartyInfo.builder().id(StandardId.of("counterparty", "JPM")).build())
				.userInfo(
						UserInfo.builder().id(StandardId.of("user", "mb")).build())
				.trade(FxSingleTrade.builder().product(fx)
						.info(TradeInfo.builder().id(StandardId.of("example", "1"))
								.addAttribute(TradeAttributeType.DESCRIPTION, "GBP 10,000/USD @ 1.62 fwd")
								.counterparty(StandardId.of("example", "BigBankA"))
								.settlementDate(LocalDate.of(2014, 9, 15)).build())
						.build())
				.build();

		// Workable solution: combination of JodaBean Serialization and MongoDB driver Jason object
		BasicDBObject obj=  BasicDBObject.parse(JodaBeanSer.PRETTY.jsonWriter().write(fxTransaction));
		coll.save(obj);

		DBCursor dbCursor = db.getCollection("transaction").find(new BasicDBObject("id", "transactionID~DC123456"));
		try {
			while(dbCursor.hasNext()) {
				DBObject dbObject = dbCursor.next();
				dbObject.removeField("_id");
				String jsonFile = JSON.serialize(dbObject);
				Transaction backFromMongo = JodaBeanSer.PRETTY.jsonReader().read(jsonFile, Transaction.class);
				backFromMongo.getTrade();
			}
		}
		finally {
			dbCursor.close();
		}
 		
		
		
		// Sample for Joda Bean Serialization.
		System.out.println(JodaBeanSer.PRETTY.jsonWriter().write(fxTransaction));

		Transaction fxTransactionOriginal = JodaBeanSer.PRETTY.jsonReader()
				.read(JodaBeanSer.PRETTY.jsonWriter().write(fxTransaction), Transaction.class);

		
		// Sample for test TradeAttributeType Usage
		TradeInfo tradeInfoTest = TradeInfo.builder().id(StandardId.of("example", "1"))
				.addAttribute(TradeAttributeType.DESCRIPTION, "GBP 10,000/USD @ 1.62 fwd")
				.addAttribute(TradeAttributeType.of("dealer"), StandardId.of("userinfo", "123"))
				.counterparty(StandardId.of("example", "BigBankA")).settlementDate(LocalDate.of(2014, 9, 15)).build();

		System.out.println(JodaBeanSer.PRETTY.jsonWriter().write(tradeInfoTest));

		// Not Working, try to use BeanMongoDBObject
        // DBObject fxTransactionDocument = new BasicDBObject("x", JodaBeanSer.PRETTY.jsonWriter().write(fxTransaction));
		// DBObject doc = new BeanMongoDBObject(fxTransaction);
		// coll.insert(fxTransactionDocument);
		// DBObject doc = new
		// BeanMongoDBObject(TestJodaBean2.builder().testjodaBean(TestJodaBean.builder()._id("random2").scheme("c").value("d").build())._id("random2").scheme("c").build());
		// doc.put("testjodaBean", new
		// BeanMongoDBObject(TestJodaBean.builder()._id("random2").scheme("c").value("d").build()));
		// coll.insert(doc);

		// DBObject myDocument = new BasicDBObject();
		// myDocument.put("_parentId", "abcd");
		// DBObject aDictionary = new BasicDBObject("actionId", "abcd")
		// .append("bDictionary", new BasicDBObject("id", "abcd"));
		// myDocument.put("aDictionary", aDictionary);
		// coll.insert(myDocument);
		

		// Not working, try to write own codec for Joda Beans
        //	DBObject fxTransactionDoc = generateDoCRecursiv(fxTransaction);
        //	coll.insert(fxTransactionDoc);
	}

	// Unused code
	public static DBObject generateDoCRecursiv(Bean jodaBean) {
		DBObject dbDoc = new BasicDBObject();
		for (String propertyName : jodaBean.propertyNames()) {
			if (jodaBean.property(propertyName).get() instanceof Bean) {
				DBObject recurDoc = generateDoCRecursiv((Bean) jodaBean.property(propertyName).get());
				dbDoc.put(propertyName, recurDoc);
			} else if (jodaBean.property(propertyName).get() instanceof LocalDate) {
				Instant instant = ((LocalDate) jodaBean.property(propertyName).get()).atStartOfDay()
						.atZone(ZoneId.systemDefault()).toInstant();
				Date date = Date.from(instant);
				dbDoc.put(propertyName, date);
			} else if (jodaBean.property(propertyName).get() instanceof Map) {
				// TODO: skip map for now
				continue;
			} else if (jodaBean.property(propertyName).get() instanceof CurrencyAmount) {
				DBObject currencyAmountDoc = new BasicDBObject();
				CurrencyAmount currencyAmount = (CurrencyAmount) jodaBean.property(propertyName).get();
				currencyAmountDoc.put("amount", currencyAmount.getAmount());
				currencyAmountDoc.put("currency", currencyAmount.getCurrency().getCode());
				dbDoc.put(propertyName, currencyAmountDoc);
			} else {
				dbDoc.put(propertyName, jodaBean.property(propertyName).get());
			}
		}
		return dbDoc;
	}
	*/
	// TODO Read back the Json data back to JodaBean
}
