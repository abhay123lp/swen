package swen.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TagTest extends AbstractDataTest {

	@Test
	public void list() {
		TagHome tagHome = new TagHome();
		List<Tag> tags = tagHome.list(0, 10);
		Assert.assertEquals(10, tags.size());
		
		Tag tag = tagHome.load(tags.get(0).getId());
		Assert.assertNotNull(tag);
	}
	
}
