package swen.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swen.data.Article;
import swen.data.ArticleHome;
import swen.data.Category;
import swen.data.CategoryHome;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryHome categoryHome;
	private ArticleHome articleHome;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryServlet() {
		super();
		categoryHome = new CategoryHome();
		articleHome = new ArticleHome();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getPathInfo().substring(1));
		Category category = categoryHome.load(id);
		request.setAttribute("category", category);
		List<Article> articles = articleHome.listByCategory(id, 0, 12);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/category.jsp")
				.forward(request, response);
	}

}
