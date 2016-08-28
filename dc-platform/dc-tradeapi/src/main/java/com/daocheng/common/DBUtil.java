package com.daocheng.common;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class DBUtil {

	static MongoDatabase dbCon = null;

	public static MongoDatabase getDBConnection() {
		if (dbCon == null) {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			dbCon = mongoClient.getDatabase("dc-tradeapi");
		}
		return dbCon;
	}

}
