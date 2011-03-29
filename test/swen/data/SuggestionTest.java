package swen.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SuggestionTest extends AbstractDataTest {

	@Test
	public void suggest() {
		SuggestionHome suggestionHome = new SuggestionHome();
		List<Suggestion> suggestions = suggestionHome.suggest(1, 10);
		Assert.assertEquals(10, suggestions.size());
	}
	
}
