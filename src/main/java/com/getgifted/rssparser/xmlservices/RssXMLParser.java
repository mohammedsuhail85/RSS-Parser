package com.getgifted.rssparser.xmlservices;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import com.getgifted.rssparser.model.RssFeed;

/**
 * @author Dell Vostro Jun 17, 2023 com.getgifted.rssparser.xmlservices
 */

public class RssXMLParser {

	static final String ITEM = "item";
	static final String GUID = "guid";
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String PUBDATE = "pubDate";
	static final String AUTHOR = "author";

	final URL url;

	public RssXMLParser(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<RssFeed> readData() {
		List<RssFeed> feedList = new ArrayList<RssFeed>();

		try {
			boolean isFeedHeader = true;
			String description = "";
			String title = "";
			String pubDate = "";
			String guid = "";
			
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = read();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					String localPart = event.asStartElement().getName().getLocalPart();
					switch (localPart) {
					case ITEM:
						if (isFeedHeader) {
							isFeedHeader = false;
						}
						event = eventReader.nextEvent();
						break;
					case GUID: 
						guid = getCharacterData(event, eventReader);
						break;
					case TITLE:
						title = getCharacterData(event, eventReader);
						break;
					case DESCRIPTION:
						description = getCharacterData(event, eventReader);
						break;
					case PUBDATE:
						pubDate =  getCharacterData(event, eventReader);
						break;
					}
					
				} else if(event.isEndElement()) {
					if(event.asEndElement().getName().getLocalPart() == (ITEM)) {
						RssFeed feed = new RssFeed();
						feed.setDescription(description);
						feed.setPublicationDate(pubDate);
						feed.setTitle(title);
						feed.setFeedId(guid);
						
						// Adding to the temporary list
						feedList.add(feed);
						
						event = eventReader.nextEvent();
						continue;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeErrorException(null, "Error Parsing XML");
		}
		return feedList;
	}

	private InputStream read() {
		try {
			return url.openStream();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
		String result = "";
		event = eventReader.nextEvent();
		if (event instanceof Characters) {
			result = event.asCharacters().getData();
		}
		return result;
	}
}
