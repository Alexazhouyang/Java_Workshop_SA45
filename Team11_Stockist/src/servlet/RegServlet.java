package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.Users;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Users users = new Users();
		String username,firstname,lastname,email,phonenumber,address,password,role;
		try {
			username=request.getParameter("username");
			firstname=request.getParameter("firstname");
			lastname=request.getParameter("lastname");
			password=request.getParameter("password");
			email=request.getParameter("email");
			phonenumber=request.getParameter("phonenumber");
			address=request.getParameter("address");
			role=request.getParameter("role");
			
			users.setUsername(username);
			users.setFirstname(firstname);
			users.setLastname(lastname);
			users.setEmail(email);
			users.setPassword(password);
			users.setPhonenumber(phonenumber);
			users.setAddress(address);
			users.setRole(role);
			UserDAO userDAO = new UserDAO();
			
			userDAO.insertUser(users);
			request.getSession().setAttribute("regUser", users);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
