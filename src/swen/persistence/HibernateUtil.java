package swen.persistence;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	
	public static void init(String path) throws IOException {
		Configuration hconf = new Configuration();
		Properties properties = new Properties();
		properties.load(new FileReader(path));
		hconf.addProperties(properties);
		hconf.configure("hibernate.cfg.xml");
		sessionFactory = hconf.buildSessionFactory();
	}

	/**
	 * Use double checking to initialize session factory. I know that double
	 * checking is not safe but it rarely fails and we use lazy startup only in
	 * development so it's OK.
	 * 
	 * @author cumeo89
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		if (sessionLocal.get() == null || !sessionLocal.get().isOpen()) {
			sessionLocal.set(getSessionFactory().openSession());
		}
		return sessionLocal.get();
	}

	public static void closeSession() {
		if (sessionLocal.get() != null) {
			Session session = sessionLocal.get();
			if (session != null && session.isOpen()) {
				session.flush();
				Transaction tx = session.getTransaction();
				if (tx.isActive()) {
					try {
						tx.commit();
					} catch (HibernateException ex) {
						tx.rollback();
					}
				}
				session.close();
			}
			sessionLocal.set(null);
		}
	}

	public static void destroy() {
		sessionFactory.close();
	}

}
