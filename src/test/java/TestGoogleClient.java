import static org.junit.Assert.assertEquals;

import java.util.List;

import org.jsoup.select.Elements;
import org.junit.Test;

import com.mrb.scanweb.GoogleClient;
import com.mrb.scanweb.google.GoogleWebSearch;
import com.mrb.scanweb.google.SearchQuery;
import com.mrb.scanweb.google.SearchResult;
import com.mrb.scanweb.hitparser.HitParser;

public class TestGoogleClient {

	@Test
	public void testGetURLs() {
		SearchQuery query = new SearchQuery.Builder("marta rey")
				.site("").numResults(10).build();
		SearchResult result = new GoogleWebSearch().search(query);
		assertEquals(result.getSize(), 15);
	}
	
	@Test
	public void testParseHit(){
		try {
			Elements textResults = HitParser.parseFirstResult("marta rey");
			System.out.println(textResults.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
