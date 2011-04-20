package swen.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swen.data.Article;
import swen.data.ArticleHome;
import swen.data.User;
import swen.data.UserHome;

/**
 * Servlet implementation class VerifyUser
 */
public class VerifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserHome userHome;
    ArticleHome articleHome;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyUser() {
        super();
        userHome=new UserHome();
        articleHome = new ArticleHome();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user= userHome.load(username);
		if(user!=null){
			if(user.getPassword().equals(password)) {
				request.getSession().setAttribute("signIn", true);
				request.getSession().setAttribute("userId", user.getId());
				List<Article> articles = articleHome.listHome(10);
				request.setAttribute("articles",articles);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("signIn",false);
			request.setAttribute("signInFail", true);
			request.getRequestDispatcher("/signIn.jsp").forward(request, response);
		}
		
	}


}
