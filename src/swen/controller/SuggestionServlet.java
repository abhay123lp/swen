package swen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swen.data.Article;
import swen.data.ArticleHome;
import swen.data.Suggestion;
import swen.data.SuggestionHome;

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
		SuggestionHome suggestionHome=new SuggestionHome();
		long userId=(Long)request.getSession().getAttribute("userId");
		List<Suggestion> suggests = suggestionHome.suggest(userId, 10);
		request.getSession().setAttribute("suggests", suggests);
		List<Article> articles=new LinkedList<Article>();
		for(int i=0;i<suggests.size();i++){
			articles.add(suggests.get(i).getArticle());
		}
		request.setAttribute("suggestArticles",articles);
		request.getRequestDispatcher("suggest.jsp").forward(request, response);
	}
}
