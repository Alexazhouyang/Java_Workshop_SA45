package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.NotFoundException;
import model.User;
import service.UserService;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path;
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		
		User user = new User();
		user.setName(u);
		user.setPassword(p);
		
		UserService service;
		User loginUser;
		
		
		
		try {
		 	 service = new UserService();
	    	 loginUser = service.authenticate(user);
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("profile", loginUser);
	    	 
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		if(service.checkLoginUser(user)){
			User lu = (User)request.getSession().getAttribute("profile");
			
			if (lu.getRole().equals("admin")){	
				
				path = "/LogOut";
				
			}
			else{
				
				path = "/LogOut";
			}
		}
		else{
			request.setAttribute("error","Invalid Username or Password !!");
			path = "/pages/login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher( path);
		rd.forward(request, response);
	}
		


}
