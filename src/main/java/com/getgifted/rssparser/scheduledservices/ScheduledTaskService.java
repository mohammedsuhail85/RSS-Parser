package com.getgifted.rssparser.scheduledservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.getgifted.rssparser.model.RssFeed;
import com.getgifted.rssparser.service.RssFeedService;
import com.getgifted.rssparser.xmlservices.RssXMLParser;

/**
 * @author Dell Vostro
 * Jun 17, 2023
 * com.getgifted.rssparser.scheduledservices
 */

@Component
public class ScheduledTaskService {
	
	@Autowired
	private RssFeedService rssFeedService;

	// 5 minutes interval
	@Scheduled(fixedRate = 300000)
	public void runTask() {
		System.out.println("Task Running : " + new Date());
		
		RssXMLParser parser = new RssXMLParser("https://feeds.simplecast.com/54nAGcIl");
		List<RssFeed> list = parser.readData();
		
		List<String> idList = new ArrayList<>();
		list.forEach(ele-> idList.add(ele.getFeedId()));
		
		System.out.println("Feed Id List : " + idList.toString());
		
		try {
			rssFeedService.saveAll(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
