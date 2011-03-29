package swen.data;

import java.util.Date;

import org.junit.Test;

public class ViewTest extends AbstractDataTest {

	@Test
	public void save() {
		ArticleHome articleHome = new ArticleHome();
		ViewHome viewHome = new ViewHome();
		UserHome userHome = new UserHome();

		Article article = articleHome.list(0, 1).get(0);
		User admin = userHome.load(1);
		View view = new View(admin, article, new Date());
		
		viewHome.save(view);
	}
	
}
