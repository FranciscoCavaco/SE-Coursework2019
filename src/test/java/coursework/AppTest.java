package coursework;

import java.sql.*;
import org.junit.*;
import com.mysql.*;


public class AppTest {
	@Test
	public void Can_retrieve_all_customers_without_sales_rep() throws SQLException{
		
		CustomerData cd = new CustomerData("","");
		
		ResultSet rs = cd.AllWithoutSalesRep();
		
		Assert.assertEquals(22, rs.getRow());
	}

}
