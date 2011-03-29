package swen.data;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import swen.persistence.HibernateUtil;

public class AbstractDataTest {

	@BeforeClass
	public static void setup() throws IOException {
		HibernateUtil.init("WebContent/WEB-INF/hibernate.properties");
	}
	
	@AfterClass
	public static void teardown() {
		HibernateUtil.destroy();
	}
	
}
