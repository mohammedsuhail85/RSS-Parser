package com.getgifted.rssparser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.getgifted.rssparser.model.PageSettings;
import com.getgifted.rssparser.model.RssFeed;
import com.getgifted.rssparser.repository.RssFeedRepository;

/**
 * @author Dell Vostro Jun 17, 2023 com.getgifted.rssparser.service
 */

@Service
public class RssFeedService {

	@Autowired
	private RssFeedRepository rssFeedRepository;

	public List<RssFeed> getAll() {
		List<RssFeed> list = new ArrayList<RssFeed>();
		rssFeedRepository.findAll().forEach(ele -> list.add(ele));
		return list;
	}

	public RssFeed save(RssFeed rssFeed) {
		return rssFeedRepository.save(rssFeed);
	}

	public List<RssFeed> saveAll(List<RssFeed> rssFeedList) throws Exception {
		rssFeedRepository.saveAll(rssFeedList);
		return getAll();
	}

	public Page<RssFeed> findPaginated(@NonNull PageSettings pageSettings) {
		return rssFeedRepository.getRssFeeds(PageRequest.of(pageSettings.getPage(), pageSettings.getSize(),
				pageSettings.getDirection() == null ? Direction.DESC : Direction.ASC, pageSettings.getKey()));
	}
}
