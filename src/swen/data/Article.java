package swen.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Article {

	private long id;
	private String name;
	private String content;
	private Date publishDate;
	private long viewCount;
	private long rateTotal;
	private long rateCount;
	private String url;
	private Set<Tag> tags = new HashSet<Tag>();

	public Article() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	public long getRateTotal() {
		return rateTotal;
	}

	public void setRateTotal(long rateTotal) {
		this.rateTotal = rateTotal;
	}

	public long getRateCount() {
		return rateCount;
	}

	public void setRateCount(long rateCount) {
		this.rateCount = rateCount;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

}
