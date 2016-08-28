package com.daocheng.clearout;
//package com.daocheng.trade.api.impl.rest;
//
//import org.joda.beans.ser.JodaBeanSer;
//import org.restlet.resource.Get;
//import org.restlet.resource.ServerResource;
//
//import com.daocheng.trade.api.DBUtil;
//import com.daocheng.trade.api.TradeAPI;
//import com.daocheng.transaction.Transaction;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.util.JSON;
//import com.opengamma.strata.basics.StandardId;
//import com.opengamma.strata.product.Trade;
//
//public class TradeAPIRest extends ServerResource implements TradeAPI {
//
//	@Override
//	public void createTrade(Trade trade) {
//
//	}
//
//	@Override
//	public void deleteTrade(Trade trade) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	@Get("json")
//	public String getLatestTrade(StandardId tradeId) {
//
//		DB db = DBUtil.getDBConnection();
//		DBCollection collection = db.getCollection("transaction");
//
//		DBCursor dbCursor = collection.find(new BasicDBObject("id", "transactionID~DC123456"));
//
//		DBObject mongoDBObject = dbCursor.next();
//		mongoDBObject.removeField("_id");
//		String jsonFile = JSON.serialize(mongoDBObject);
//		return jsonFile;
//
//	}
//
//}
