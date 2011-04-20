package swen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swen.data.Article;
import swen.data.ArticleHome;
import swen.data.Suggestion;
import swen.data.SuggestionHome;
import swen.data.SuggestionStatus;

import java.util.LinkedList;
/**
 * Servlet implementation class SuggestionResult
 */
public class SuggestionResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestionResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Suggestion> result=(ArrayList<Suggestion>)request.getSession().getAttribute("suggests");
		Suggestion tempSuggestion=new Suggestion();
		SuggestionHome suggestionHome=new SuggestionHome();
		String checkbox[]=request.getParameterValues("checkbox[]");
		String tempString = new String();
		for(int i=0;i<10;i++){
			for(int j=0;j<checkbox.length;j++)
				if(result.get(i).getArticle().getId()==Long.parseLong(checkbox[j])) 
					suggestionHome.load(result.get(i).getId()).setStatus(SuggestionStatus.ACCEPTED);
				else 
					suggestionHome.load(result.get(i).getId()).setStatus(SuggestionStatus.REJECTED);
		}

		ArticleHome articleHome=new ArticleHome();
		List<Article> articles=articleHome.listHome(10);
	    request.setAttribute("articles", articles);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
