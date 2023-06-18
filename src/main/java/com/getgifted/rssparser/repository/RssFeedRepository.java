package com.getgifted.rssparser.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.getgifted.rssparser.model.RssFeed;

/**
 * @author Dell Vostro Jun 17, 2023 com.getgifted.rssparser.repository
 */
public interface RssFeedRepository extends JpaRepository<RssFeed, String> {

	@Query(value = "SELECT rf FROM RssFeed rf ")
    Page<RssFeed> getRssFeeds(final Pageable pageable);
}
