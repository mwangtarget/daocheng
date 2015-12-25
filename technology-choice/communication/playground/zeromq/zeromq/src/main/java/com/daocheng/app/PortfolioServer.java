package com.daocheng.app;

import org.zeromq.ZMQ;

import com.daocheng.core.model.Trade;

public class PortfolioServer {

	public static void main(String[] args) {
		final ZMQ.Context context = ZMQ.context(1);
		final ZMQ.Socket publisher = context.socket(ZMQ.PUB);

		// Subscriber tells us when it's ready here
		final ZMQ.Socket sync = context.socket(ZMQ.PULL);

		sync.bind("tcp://*:5561");

		// We send updates via this socket
		publisher.bind("tcp://*:5562");

		System.out.println("Publisher Running");

		// Wait for synchronization request
		sync.recv(0);

		Trade.Contract contract= Trade.Contract.newBuilder().setInstrument("EUR/USD").setNotional(10_000).build();
		Trade.Transaction transaction = Trade.Transaction.newBuilder().setContract(contract).setCounterparty("JPM").build();
		Trade.Portfolio portfolio = Trade.Portfolio.newBuilder().setName("G10_ALL").addTransaction(transaction).build();


		final long start = System.currentTimeMillis();
		int i;
		for (i = 0; i != 10; i++) {
			System.out.println(i);
			final byte[] byteArray = portfolio.toByteArray();
			System.out.println(byteArray);
			System.out.println(byteArray.length);
			publisher.send(portfolio.toByteArray(), 0); // serialization
		}
		final long end = System.currentTimeMillis();
		final long diff = (end - start);

		System.out.println("time taken to send messages " + i + " is :" + diff);
	}
}
