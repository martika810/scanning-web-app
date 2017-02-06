package com.mrb.scanweb.hitparser;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mrb.scanweb.google.GoogleWebSearch;
import com.mrb.scanweb.google.SearchQuery;
import com.mrb.scanweb.google.SearchResult;

public class HitParser {

	public static void parseFirstResult() throws Exception {
		//query google
		SearchQuery query = new SearchQuery.Builder("bunnies").site("")
				.numResults(10).build();
		SearchResult result = new GoogleWebSearch().search(query);
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(result.getUrls().get(0));
		HttpResponse htmlResponse = null;
	    try {
	    	htmlResponse = client.execute(getRequest);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    String documentText = EntityUtils.toString(htmlResponse.getEntity());
	    Document searchDoc = Jsoup.parse(documentText);
	    Elements text = searchDoc.select("p");
	}

}
