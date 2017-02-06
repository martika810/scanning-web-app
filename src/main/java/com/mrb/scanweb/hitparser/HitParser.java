package com.mrb.scanweb.hitparser;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public static Elements parseFirstResult(final String queryText)
			throws Exception {
		// query google
		SearchQuery query = new SearchQuery.Builder(queryText).site("")
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
		return text;
	}

	public static List<Elements> parseResult(final String queryText)
			throws ParseException, IOException {
		SearchQuery query = new SearchQuery.Builder(queryText).site("")
				.numResults(10).build();
		SearchResult result = new GoogleWebSearch().search(query);
		List<Elements> elements = null;
		try {
			elements = result.getUrls().stream().parallel()
					.map(s -> callURL(s)).collect(Collectors.toList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return elements;

	}

	private static Elements callURL(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse htmlResponse = null;
		HttpGet getRequest = new HttpGet(url);
		Elements text =null;
		try {
			htmlResponse = client.execute(getRequest);
			String documentText = EntityUtils
					.toString(htmlResponse.getEntity());
			Document searchDoc = Jsoup.parse(documentText);
			text = searchDoc.select("p");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

}
