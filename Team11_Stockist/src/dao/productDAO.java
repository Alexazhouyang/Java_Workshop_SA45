package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Products;
import entity.Supplier;
import util.DBHelper;

public class productDAO {
	
	/**
	 * update supplier information
	 */
	
	public void updateProduct(Products user) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql = "UPDATE product SET productName= '"
			+ user.getProductName()
			+"',unitPrice='"
			+ user.getUnitPrice()
			+"',supplierID='"
			+ user.getSupplierID()
			+"',description='"
			+ user.getDescription()
			+"',color='"
			+ user.getColor()
			+"',dimension='"
			+ user.getDimension()
			+"',manufacturer='"
			+ user.getManufacturer()
			+"',reorderLevel='"
			+ user.getReorderLevel()
			+"',minOrderQty='"
			+ user.getMinOrderQty()
			+"',shelfLocation='"
			+ user.getShelfLocation()
			+"',qty='"
			+ user.getQty()
			+"',damageQty='"
			+ user.getDamageQty()
			
			+"' WHERE productID="+ user.getProductID();
			
			statement.executeUpdate(sql);				
			} catch (SQLException e) {
			e.printStackTrace();
			}	
		}
	
	/**
	 * insert product information
	 */
	
	public void insertProduct(Products user) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql = "INSERT INTO product ( productName, unitPrice,supplierID, description,"
					+ "color,dimension,manufacturer,reorderLevel,,minOrderQty,shelfLocation,qty,damageQty) VALUES ('"
					+ user.getProductName()
					+"','"
					+ user.getUnitPrice()
					+"','"
					+ user.getSupplierID()
					+"','"
					+ user.getDescription()
					+"','"
					+ user.getColor()
					+"','"
					+ user.getDimension()
					+"','"
					+ user.getManufacturer()
					+"','"
					+ user.getReorderLevel()
					+"','"
					+ user.getMinOrderQty()
					+"','"
					+ user.getShelfLocation()
					+"','"
					+ user.getQty()
					+"','"
					+ user.getDamageQty()
					+ "')";
			
			statement.executeUpdate(sql);				
			} catch (SQLException e) {
			e.printStackTrace();
			}	
		}
	
	
	/**
	 * select supplier information
	 * @param userid
	 
	 * @return
	 */
		public ArrayList<Products> selectProduct() {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;	
			Products products = new Products();
			ArrayList<Products> list = new ArrayList<Products>();
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM product ";
						rs = statement.executeQuery(sql);
						while (rs.next()) {	
							products = new Products();
							products.setProductID(rs.getInt("productID"));
							products.setProductName(rs.getString("productName"));
							products.setUnitPrice(rs.getFloat("unitPrice"));
							products.setSupplierID(rs.getInt("supplierID"));
							products.setDescription(rs.getString("description"));
							products.setColor(rs.getString("color"));
							products.setDimension(rs.getString("dimension"));
							products.setManufacturer(rs.getString("manufacturer"));
							products.setReorderLevel(rs.getString("reorderLevel"));
							products.setMinOrderQty(rs.getInt("minOrderQty"));
							products.setShelfLocation(rs.getString("shelfLocation"));
							products.setQty(rs.getInt("qty"));
							products.setDamageQty(rs.getInt("damageQty"));
							list.add(products);					
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		public ArrayList<Products> selectProductsByName(String productName) {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;	
			Products products =new Products();
			ArrayList<Products> list = new ArrayList<Products>();
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM product WHERE productName LIKE '%"+ productName + "%'";
						rs = statement.executeQuery(sql);
						while (rs.next()) {	
							products = new Products();
							products.setProductID(rs.getInt("productID"));
							products.setProductName(rs.getString("productName"));
							products.setUnitPrice(rs.getFloat("unitPrice"));
							products.setSupplierID(rs.getInt("supplierID"));
							products.setDescription(rs.getString("description"));
							products.setColor(rs.getString("color"));
							products.setDimension(rs.getString("dimension"));
							products.setManufacturer(rs.getString("manufacturer"));
							products.setReorderLevel(rs.getString("reorderLevel"));
							products.setMinOrderQty(rs.getInt("minOrderQty"));
							products.setShelfLocation(rs.getString("shelfLocation"));
							products.setQty(rs.getInt("qty"));
							products.setDamageQty(rs.getInt("damageQty"));
							list.add(products);					
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public void deleteoneProducts(int productID) {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="DELETE FROM product WHERE productID = "+ productID;
				statement.executeUpdate(sql);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
			
			
		
	
	
	

}
