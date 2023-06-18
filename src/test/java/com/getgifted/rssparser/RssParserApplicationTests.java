package com.getgifted.rssparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort.Direction;

import com.getgifted.rssparser.model.PageSettings;
import com.getgifted.rssparser.service.RssFeedService;
import com.getgifted.rssparser.xmlservices.RssXMLParser;

@SpringBootTest
class RssParserApplicationTests {

	@Autowired
	private RssFeedService rssFeedService;

	@Test
	void contextLoads() {
	}

	@Test
	void TestRssFeed() {
		RssXMLParser parser = new RssXMLParser("https://feeds.simplecast.com/54nAGcIl");
		int listSize = parser.readData().size();

		System.out.println("size : " + listSize);
		// Checking the list size is not null
		assertNotNull(listSize);
	}

	@Test
	void TestRssFeedPaginated() {
		int pageContentSize = rssFeedService.findPaginated(new PageSettings(0, 5, "publicationDate", Direction.DESC))
				.getContent().size();

		System.out.println("size : " + pageContentSize);
		// Checking the contents size of the response
		assertEquals(5, pageContentSize);
	}
}
