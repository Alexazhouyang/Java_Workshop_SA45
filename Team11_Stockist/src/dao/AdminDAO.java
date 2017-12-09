package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Users;
import util.DBHelper;

public class AdminDAO {
	
	
	
	
	public void insertAdmin(Users user , int userid) {
		
	DBHelper dbHelper = new DBHelper();
	String sql = "";
	Connection connection = null;
	Statement statement = null;

	
	try {
		
		connection = dbHelper.initDB();
		statement =connection.createStatement();
		
		sql = "INSERT INTO administrator ( userID, firstName, lastName, email , phoneNumber , address , description) VALUES ('"
				+ userid
				+ "','"
				+ user.getFirstname()
				+ "','"
				+ user.getLastname()
				+ "','"
				+ user.getEmail()
				+ "','"
				+ user.getPhonenumber()
				+ "','"
				+ user.getAddress()
				+ "','"
				+ user.getDescription()
				+ "')";
		
		statement.executeUpdate(sql);
        
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	/**
	 * select administrator information
	 * @param userid
	 
	 * @return
	 */
		public Users selectAdmin(Users users,int userid) {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;		
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM administrator WHERE userID = "
						+ userid ;
						rs = statement.executeQuery(sql);
						while (rs.next()) {							
							
							users.setFirstname(rs.getString("firstName"));							
							users.setLastname(rs.getString("lastName"));
							users.setEmail(rs.getString("email"));
							users.setPhonenumber(rs.getString("phoneNumber"));
							users.setAddress(rs.getString("address"));
							users.setDescription(rs.getString("description"));
							
							
							
							
							
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return users;
		}


}
