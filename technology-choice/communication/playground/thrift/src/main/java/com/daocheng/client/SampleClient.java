package com.daocheng.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.daocheng.idl.gen.NormalDate;
import com.daocheng.idl.gen.WeekendChecker;

public class SampleClient {
	public static void main(String[] args) {

		

		try {
			TTransport transport = null;

			transport = new TSocket("localhost", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			WeekendChecker.Client client = new WeekendChecker.Client(protocol);

			perform(client);

			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}
	}

	private static void perform(WeekendChecker.Client client) throws TException {

		NormalDate inputDate = new NormalDate(2015, 12, 24);
		System.out.println(client.isWeekend(inputDate));
	}

}
