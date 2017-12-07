package dao;


import dao.mysql.MySQLConstants;

import dao.mysql.UserDAOImpl;

public class DaoFactory {
	
	private static String dbType;
	
	
	public DaoFactory(String dbType){
		DaoFactory.dbType = dbType;
	}
	
	
	
	public static UserDAO getUserDao(){
		UserDAO udao = new UserDAOImpl();
		return udao;
	}
	

	
}
