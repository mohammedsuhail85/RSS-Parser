package com.getgifted.rssparser.model;

import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

/**
 * @author Dell Vostro Jun 18, 2023 com.getgifted.rssparser.model
 */

@Data
public class PageSettings {

	private int page = 0;

	private int size = 2;

	Direction direction = Direction.ASC;

	private String key;

	public PageSettings(int page, int size, String key, Direction direction) {
		this.key = key;
		this.size = size;
		this.page = page;
		this.direction = direction;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "PageSettings [page=" + page + ", size=" + size + ", direction=" + direction + ", key=" + key + "]";
	}

}