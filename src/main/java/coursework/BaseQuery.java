package coursework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseQuery {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels";

	public BaseQuery(String uname, String pwd){
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
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

}
