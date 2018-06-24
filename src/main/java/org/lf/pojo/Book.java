package org.lf.pojo;

import java.util.Date;

public class Book {
	private String title;
	private String topic;
	private Date pubDate;

	public Book(String title, String topic, Date pubDate) {
		this.title = title;
		this.topic = topic;
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", topic='" + topic + '\'' + ", pubDate=" + pubDate + '}';
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
