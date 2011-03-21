package swen.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import swen.persistence.HibernateUtil;

/**
 * Servlet Filter implementation class HibernateSessionFilter
 */
public class CommonFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CommonFilter() {
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			request.setAttribute("swen", true);
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
