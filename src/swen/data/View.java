package swen.data;

import java.util.Date;

public class View {

	private User user;
	private Article article;
	private Date time;

	public View() {
	}

	public View(User user, Article article, Date time) {
		super();
		this.user = user;
		this.article = article;
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
