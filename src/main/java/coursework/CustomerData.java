package coursework;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerData extends BaseQuery 
{

	public CustomerData(String uname, String pwd) {
		super(uname, pwd);
		// TODO Auto-generated constructor stub
	}
	
	public ResultSet AllWithoutSalesRep() throws SQLException {
		
		ResultSet rs = super.ExecuteQuery("select customerName, City from customers where salesRepEmployeeNumber is NULL;");
		return rs;
		
	}
}
