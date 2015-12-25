package com.daocheng.technology_choose.communication.resful_spark;

import java.time.LocalDate;
import java.util.Date;

public class Trade {

	private int tradeId;
	private String porfolio;
	private String counterparty;
	private String currency;
	private int notional;
	private LocalDate valueDate;

	public int getTradeId() {
		return tradeId;
	}

	public String getPorfolio() {
		return porfolio;
	}

	public String getCounterparty() {
		return counterparty;
	}

	public String getCurrency() {
		return currency;
	}

	public int getNotional() {
		return notional;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	private Trade(int tradeId, String portfolio, String counterparty, String currency, int notional, LocalDate valueDate) {
		this.tradeId = tradeId;
		this.porfolio = portfolio;
		this.counterparty = counterparty;
		this.currency = currency;
		this.notional = notional;
		this.valueDate = valueDate;
	}

	public static class Builder {
		private int tradeId;
		private String portfolio;
		private String counterparty;
		private String currency;
		private int notional;
		private LocalDate valueDate;

		public Builder tradeId(int tradeId) {
			this.tradeId = tradeId;
			return this;
		}

		public Builder portfolio(String portfolio) {
			this.portfolio = portfolio;
			return this;
		}

		public Builder counterparty(String counterparty) {
			this.counterparty = counterparty;
			return this;
		}

		public Builder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public Builder notional(int notional) {
			this.notional = notional;
			return this;
		}

		public Builder valueDate(LocalDate valueDate) {
			this.valueDate = valueDate;
			return this;
		}

		public Trade build() {
			return new Trade(this.tradeId, this.portfolio, this.counterparty, this.currency, this.notional,
					this.valueDate);
		}
	}

}
