package swen.data;

public class Suggestion {

	private long id;
	private User user;
	private Article article;
	private SuggestionStatus status;
	private float probability;

	public Suggestion() {
	}

	public Suggestion(User user, Article article, SuggestionStatus status,
			float probability) {
		super();
		this.user = user;
		this.article = article;
		this.status = status;
		this.probability = probability;
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

	public SuggestionStatus getStatus() {
		return status;
	}

	public void setStatus(SuggestionStatus status) {
		this.status = status;
	}

	public float getProbability() {
		return probability;
	}

	public void setProbability(float probability) {
		this.probability = probability;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return article.toString();
	}
	
}
