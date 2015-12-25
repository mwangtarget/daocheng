package com.daocheng.app;

import org.zeromq.ZMQ;

import com.daocheng.core.model.Trade;

public class PortfolioClient {
	public static void main(String[] args) {
		final ZMQ.Context context = ZMQ.context(1);

		// Connect our subscriber socket
		final ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
		subscriber.setIdentity("hello".getBytes());

		// Synchronize with the publisher
		final ZMQ.Socket sync = context.socket(ZMQ.PUSH);

		subscriber.subscribe("".getBytes());
		subscriber.connect("tcp://localhost:5562");
		sync.connect("tcp://localhost:5561");

		sync.send("".getBytes(), 0);

		final long start = System.currentTimeMillis();
		int i;
		for (i = 0; i != 10; i++) {
			final byte[] rawBytes = subscriber.recv(0);
			try {
				System.out.println(rawBytes);
				System.out.println(rawBytes.length);
				final Trade.Portfolio data = Trade.Portfolio.parseFrom(rawBytes); // deserialization
				System.out.println(data);
			} catch (final Exception e) {
				System.err.println(e);
			}
		}
		final long end = System.currentTimeMillis();
		final long diff = (end - start);
		System.out.println("time taken to receive messages " + i + " is :" + diff);
	}
}
