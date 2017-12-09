package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.MechDAO;
import dao.UserDAO;
import entity.Users;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//get input user information
		UserDAO userDAO = new UserDAO();
		AdminDAO adminDAO =new AdminDAO();
		MechDAO mechDAO = new MechDAO();
		
		Users  users =new Users();
		String check = userDAO.judgeUserPassword(userName);
		//judge user exist?
		
		String message = "username or password error!"+userName+password;
		if(check.equals(password))
		{
			request.setAttribute("message", message);
			request.getRequestDispatcher("pages/login.jsp").forward(request,response);
		}else {
			
			
			int userid = userDAO.FindID(userName);			
			String role = userDAO.FindRole(userid);
//			users.setUsername(userName);
//			users.setUserID(userid);
//			users.setRole(role);
			if(role.equals("admin"))
			{				
				users = adminDAO.selectAdmin(users,userid);
				request.getSession().setAttribute("username", userName);
				request.setAttribute("firstname", users.getFirstname());
				request.setAttribute("lastname", users.getLastname());
				request.setAttribute("email", users.getEmail());
				request.setAttribute("phonenumber", users.getPhonenumber());
				//request.setAttribute("password", password);
				request.setAttribute("address", users.getAddress());
				request.setAttribute("description", users.getDescription());
				//request.getSession().setAttribute("regUser", users);
			request.getRequestDispatcher("admin.jsp").forward(request,response);
			}
			else {
				users = mechDAO.selectMech(users,userid);
				
				request.getSession().setAttribute("username", userName);
				request.setAttribute("firstname", users.getFirstname());
				request.setAttribute("lastname", users.getLastname());
				request.setAttribute("email", users.getEmail());
				request.setAttribute("phonenumber", users.getPhonenumber());
				//request.setAttribute("password", password);
				request.setAttribute("address", users.getAddress());
				request.setAttribute("description", users.getDescription());
				
				//request.getSession().setAttribute("regUser", users);
			request.getRequestDispatcher("mechanic.jsp").forward(request,response);
			}
		}
		
	}

}
