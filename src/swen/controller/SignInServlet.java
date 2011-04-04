package swen.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.ForwardRequest;

import sun.misc.UUDecoder;
import swen.data.Article;
import swen.data.User;
import swen.data.UserHome;
import swen.data.Article;
import swen.data.ArticleHome;

import java.util.List;
/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserHome userHome;
    private ArticleHome articleHome;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        articleHome=new ArticleHome();
        userHome = new UserHome();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user= userHome.load(username);
		if(user.getPassword().equals(password)) {
			request.setAttribute("signIn", "true");
			request.setAttribute("userId", user.getId());
			List<Article> articles = articleHome.listByCategory(1, 0, 10);
			request.setAttribute("articles",articles);
			request.getRequestDispatcher("suggest.jsp").forward(request, response);
		}
		else {
			request.setAttribute("signIn", "false");
			request.getRequestDispatcher("suggest.jsp").forward(request, response);
		}
	}

}
