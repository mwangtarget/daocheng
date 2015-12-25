package com.daocheng.technology_choose.communication.resful_spark;

import static spark.Spark.*;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * A Simple Spark restful endpoints to do the trade CRUD management.
 */
public class TradeManagementServer {

	public static void main(String[] args) {

		// Populate some sample trades in first;
		tradeDataInit();

		// Set the port number to 8080
		port(8080);

		// Get service to get one trade
		get("/trade/:tradeId", (request, response) -> {
			String tradeId = request.params(":tradeId");
			Trade returnTrade = TradeDAO.getTrade(Integer.parseInt(tradeId));
			if (returnTrade != null) {
				response.status(200);
				response.type("application/json");
				return dataToJson(returnTrade);

			} else {
				response.status(404);
				return "TradeId you request doesn't exist";
			}
		});

		// Add trade with client side to supply the new tradeId.
		post("/trade/:tradeId", (request, response) -> {
			String tradeId = request.params(":tradeId");
			Trade returnTrade = TradeDAO.getTrade(Integer.parseInt(tradeId));
			if (returnTrade != null) {
				response.status(404);
				return "TradeId supplied already exits";

			} else {
				String tradeDetail = request.body();

				Trade newTrade = jsonStrToObject(tradeDetail);
				TradeDAO.addTrade(newTrade);
				response.status(200);
				// response.type("application/json");
				return "New trade created successfully with supplied ID: " + tradeId;
			}
		});

	}

	public static void tradeDataInit() {
		Trade trade1 = new Trade.Builder().counterparty("CITI").portfolio("G10_UK").currency("EUR/USD").notional(10_000)
				.valueDate(LocalDate.of(2015, 12, 25)).tradeId(1).build();

		Trade trade2 = new Trade.Builder().counterparty("CITI").portfolio("G10_UK").currency("EUR/GBP").notional(10_000)
				.valueDate(LocalDate.of(2015, 12, 25)).tradeId(2).build();

		TradeDAO.addTrades(trade1, trade2);
	}

	// Json String to Object based on ObjectMapper, should not working for the
	// immutable class.
	public static Trade jsonToObject(String body) {
		ObjectMapper mapper = new ObjectMapper();

		Trade creation = null;
		try {
			creation = mapper.readValue(body, Trade.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creation;
	}

	// Json String to Object, work for any type, can not handle nested Jason
	public static Trade jsonStrToObject(String body) {

		Trade creation = null;
		int tradeId = 0;
		String porfolio = "";
		String counterparty = "";
		String currency = "";
		int notional = 0;
		int year = 0;
		int month = 0;
		int day = 0;
		LocalDate valueDate = LocalDate.now();

		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jParser;
		try {

			jParser = jsonFactory.createParser(body);

			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if ("tradeId".equals(fieldname)) {
					jParser.nextToken();
					tradeId = jParser.getIntValue();
				}
				if ("porfolio".equals(fieldname)) {
					jParser.nextToken();
					porfolio = jParser.getValueAsString();
				}
				if ("counterparty".equals(fieldname)) {
					jParser.nextToken();
					counterparty = jParser.getValueAsString();
				}
				if ("currency".equals(fieldname)) {
					jParser.nextToken();
					currency = jParser.getValueAsString();
				}
				if ("notional".equals(fieldname)) {
					jParser.nextToken();
					notional = jParser.getIntValue();
				}

				if ("valueDate".equals(fieldname)) {
					jParser.nextToken();
					while (jParser.nextToken() != JsonToken.END_OBJECT ) {
						String fieldnameL2 = jParser.getCurrentName();
						if ("year".equals(fieldnameL2)) {
							jParser.nextToken();
							year = jParser.getIntValue();
						}
						if ("monthValue".equals(fieldnameL2)) {
							jParser.nextToken();
							month = jParser.getIntValue();
						}
						

						if ("dayOfMonth".equals(fieldnameL2)) {
							jParser.nextToken();
							day = jParser.getIntValue();
						}
						if ("id".equals(fieldnameL2)) {
							jParser.nextToken();
							// If ID next token twice to bypass the End Object.
							jParser.nextToken();
						}
					}
				}

			}

			jParser.close();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch blockTrade creation = null;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (year == 0 & month != 0 & day != 0) {
			valueDate = LocalDate.of(year, month, day);
		}

		creation = new Trade.Builder().counterparty(counterparty).portfolio(porfolio).currency(currency)
				.notional(notional).valueDate(valueDate).tradeId(tradeId).build();

		return creation;
	}

	public static Trade jsonStrToObjectDOM(String body) {

		Trade creation = null;
		int tradeId = 0;
		String porfolio = "";
		String counterparty = "";
		String currency = "";
		int notional = 0;
		int year = 0;
		int month = 0;
		int day = 0;
		LocalDate valueDate = LocalDate.now();

		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jParser;
		try {

			jParser = jsonFactory.createParser(body);

			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if ("tradeId".equals(fieldname)) {
					jParser.nextToken();
					tradeId = jParser.getIntValue();
				}
				if ("porfolio".equals(fieldname)) {
					jParser.nextToken();
					porfolio = jParser.getValueAsString();
				}
				if ("counterparty".equals(fieldname)) {
					jParser.nextToken();
					counterparty = jParser.getValueAsString();
				}
				if ("notional".equals(fieldname)) {
					jParser.nextToken();
					notional = jParser.getIntValue();
				}

			}

			jParser.close();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch blockTrade creation = null;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		valueDate = LocalDate.of(year, month, day);

		creation = new Trade.Builder().counterparty(counterparty).portfolio(porfolio).currency(currency)
				.notional(notional).valueDate(valueDate).tradeId(tradeId).build();

		return creation;
	}

	// Object to JSON using ObjectMapper
	public static String dataToJson(Object data) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		StringWriter sw = new StringWriter();
		try {
			mapper.writeValue(sw, data);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();

	}

}
