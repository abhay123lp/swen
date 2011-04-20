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
public class VerifyNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserHome userHome;
    ArticleHome articleHome;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyNewUser() {
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
		User user= new User();
		UserHome userHome=new UserHome();
		if((username!=null)&&(password!=null)){
			if(userHome.load(username)==null){
				user.setName(username);
				user.setPassword(password);
				userHome.save(user);
				
				request.getRequestDispatcher("/").forward(request, response);
			}
			else {
				request.setAttribute("signUpFail", true);
				request.getRequestDispatcher("/signUp.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("signUpFail", true);
			request.getRequestDispatcher("/signUp.jsp").forward(request, response);
		}
		
	}


}
