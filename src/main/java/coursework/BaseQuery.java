package coursework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseQuery {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

	public BaseQuery(String uname, String pwd){
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver ();
		    
		    DriverManager.registerDriver(driver);
			
			
			con = DriverManager.getConnection( db, uname, pwd);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected ResultSet useTable(String tableName) throws SQLException{
		String query = "select * from " + tableName; 
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		return rs;
	}
	
	
	//used for Test Cases
	protected ResultSet TestQuery(String query) throws SQLException{
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		return rs;
	}
	
	protected void Close() {
		try {
		 	
			if(!con.isClosed())
			{
				con.close();
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	


}
