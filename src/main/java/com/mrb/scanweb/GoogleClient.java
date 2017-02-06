package com.mrb.scanweb;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

//import io.vertx.core.Handler;
//import io.vertx.core.Vertx;
//import io.vertx.core.http.HttpClient;
//import io.vertx.core.http.HttpClientResponse;
//import io.vertx.core.impl.VertxImpl;

public class GoogleClient {
//	private Vertx vertx;
//	private static GoogleClient INSTANCE = null;
//
//	private GoogleClient(Vertx vertx) {
//		this.vertx = vertx;
//	}
//
//	public static GoogleClient of() {
//		if (INSTANCE == null) {
//
//			return new GoogleClient(Vertx.factory.vertx());
//		}
//		return INSTANCE;
//	}
//
//	public List<String> getURLs(String text) throws Exception {
//		HttpClient httpClient = vertx.createHttpClient();
//		final List<String> list = new ArrayList<String>();
//		String urlText = "http://www.google.com/search?q="+URLEncoder.encode(text,"UTF-8");
//		
//		httpClient.getNow(urlText,
//				new Handler<HttpClientResponse>() {
//
//					public void handle(HttpClientResponse event) {
//
//						list.add("hey");
//
//					}
//				});
//		return list;
//	}

}
