package dm.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dm.persistence.HibernateUtil;

/**
 * Application Lifecycle Listener implementation class Application
 * 
 */
public class Application implements ServletContextListener {

	private ServletContext context;

	/**
	 * Default constructor.
	 */
	public Application() {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent evt) {
		context = evt.getServletContext();
		try {
			HibernateUtil.init(context
					.getRealPath("/WEB-INF/hibernate.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.destroy();
	}

}
