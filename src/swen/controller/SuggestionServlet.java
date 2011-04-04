package swen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swen.data.Article;
import swen.data.ArticleHome;

import java.util.LinkedList;
import java.util.List;
/**
 * Servlet implementation class SuggestionServlet
 */
public class SuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleHome articleHome;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestionServlet() {
        super();
        articleHome=new ArticleHome();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("signIn")=="true"){
			List<Article> articles = articleHome.listByCategory(1, 0, 10);
			request.setAttribute("articles",articles);
			request.getRequestDispatcher("suggest.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("signIn.jsp").forward(request, response);
		}

	}
}
