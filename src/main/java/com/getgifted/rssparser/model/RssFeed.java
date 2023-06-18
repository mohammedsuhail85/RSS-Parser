/**
 * 
 */
package com.getgifted.rssparser.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Dell Vostro
 * Jun 17, 2023
 * com.getgifted.rssparser.model
 */

@Entity
public class RssFeed {

	@Id
	@Column
	private String feedId;
	
	@Column
	private String title;
	
	@Column(length = 5000)
	private String description;
	
	@Column
	private String publicationDate;

	/**
	 * @return the feedId
	 */
	public String getFeedId() {
		return feedId;
	}

	/**
	 * @param feedId the feedId to set
	 */
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the publicationDate
	 */
	public String getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate the publicationDate to set
	 */
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public String toString() {
		return "RssFeed [feedId=" + feedId + ", title=" + title + ", description=" + description + ", publicationDate="
				+ publicationDate + "]";
	}
	
	
}
