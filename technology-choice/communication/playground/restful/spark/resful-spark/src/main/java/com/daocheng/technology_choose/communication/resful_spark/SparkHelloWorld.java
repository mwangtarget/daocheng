package com.daocheng.technology_choose.communication.resful_spark;

import static spark.Spark.*;

public class SparkHelloWorld {
	public static void main(String[] args) {
		get("/hello", (request, response) -> "Hello World!");
	}
}
