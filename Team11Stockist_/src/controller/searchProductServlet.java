package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productDAO;
import dao.supplierDAO;
import model.Products;
import model.Supplier;

/**
 * Servlet implementation class supplierSearchServlet
 */
@WebServlet("/searchProductServlet")
public class searchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchProductServlet() {
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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		Products products =new Products();
		String productName = null;
		productDAO productDAO = new productDAO();
		
		
		try {
			
			productName = request.getParameter("productName");
			
			if(request.getParameter("productName") != null)
			{
			ArrayList<Products> list = productDAO.selectProductsByName(productName);		
			request.setAttribute("list", list);
	        request.getRequestDispatcher("viewProduct.jsp").forward(request,
	                response);
			}
			else {
				ArrayList<Products> list = productDAO.selectProduct();		
				request.setAttribute("list", list);
		        request.getRequestDispatcher("viewProduct.jsp").forward(request,
		                response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
