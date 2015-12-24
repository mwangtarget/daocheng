package com.daocheng.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.daocheng.WeekendCheckerHandler;
import com.daocheng.idl.gen.WeekendChecker;

public class SampleServer {

	public static WeekendCheckerHandler handler;

	public static WeekendChecker.Processor processor;

	public static void main(String[] args) {
		try {
			handler = new WeekendCheckerHandler();
			processor = new WeekendChecker.Processor(handler);

			Runnable simple = new Runnable() {
				public void run() {
					simple(processor);
				}
			};

			new Thread(simple).start();

		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public static void simple(WeekendChecker.Processor processor) {
		try {
			TServerTransport serverTransport = new TServerSocket(9090);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

			// Use this for a multithreaded server
			// TServer server = new TThreadPoolServer(new
			// TThreadPoolServer.Args(serverTransport).processor(processor));

			System.out.println("Starting the simple server...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
