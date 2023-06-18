package com.getgifted.rssparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getgifted.rssparser.model.PageSettings;
import com.getgifted.rssparser.model.RssFeed;
import com.getgifted.rssparser.service.RssFeedService;

/**
 * @author Dell Vostro Jun 17, 2023 com.getgifted.rssparser.controller
 */

@RestController()
public class RssFeedController {

	@Autowired
	private RssFeedService rssFeedService;

	@PostMapping("/save")
	public RssFeed save(@RequestBody RssFeed rssFeed) {
		return rssFeedService.save(rssFeed);
	}

	@GetMapping("/items")
	public Page<RssFeed> getPaginated(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@RequestParam(defaultValue = "publicationDate", required = false) String sort,
			@RequestParam(required = false) Direction direction) {
		PageSettings pageSettings = new PageSettings(page, size, sort, direction);

		System.out.println("PARAMS : " + pageSettings.toString());
		return rssFeedService.findPaginated(pageSettings);
	}
}
