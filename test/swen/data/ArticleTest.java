package swen.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArticleTest extends AbstractDataTest {

	@Test
	public void load() {
		ArticleHome articleHome = new ArticleHome();
		List<Article> articles = articleHome.list(0, 1);
		Assert.assertEquals(1, articles.size());
	}
	
}
