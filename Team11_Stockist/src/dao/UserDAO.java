package dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import entity.Users;
import util.DBHelper;

public class UserDAO {
	
	
	public void insertUser(Users user) {
		
	DBHelper dbHelper = new DBHelper();
	String sql = "";
	Connection connection = null;
	Statement statement = null;
	
	try {
		
		connection = dbHelper.initDB();
		statement =connection.createStatement();
		sql = "INSERT INTO user ( userName, password, role) VALUES ('"
				+ user.getUsername()
				+ "','"
				+ user.getPassword()
				+ "','"
				+ user.getRole()
				+ "')";
		
		statement.executeUpdate(sql);
        
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	}

}
