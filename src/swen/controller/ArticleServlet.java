package swen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swen.data.Article;
import swen.data.ArticleHome;

/**
 * Servlet implementation class Article
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// du lieu
		ArticleHome articleHome = new ArticleHome();
		String info=request.getPathInfo().substring(1);
		int id=Integer.parseInt(info);		
		Article article = articleHome.load(id);
		request.setAttribute("article", article);
		request.getRequestDispatcher("/article.jsp").forward(request, response);
	}

}
