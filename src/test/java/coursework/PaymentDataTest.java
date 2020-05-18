package coursework;


import static org.junit.Assert.*;

import java.sql.*;
import java.util.*;
import org.junit.*;
import org.junit.Before;

public class PaymentDataTest {
	
	private CustomerData customerData = null;
	private PaymentData paymentData = null;
	private BaseQuery baseQuery = null;
	private OrderData orderData = null;
	
	private int getDbCount(String query) throws SQLException {
		ResultSet rs = baseQuery.TestQuery(query);
		rs.next();
		return rs.getInt("rowcount");	
	}
	
	private boolean SameData(ResultSet expectedRs, ArrayList<Payment> actual) throws SQLException
	{
		int i = 0;
		while(expectedRs.next()) {
			
			int customerNumber = expectedRs.getInt("CustomerNumber");
			String customerName = expectedRs.getString("customerName");
			double amount = expectedRs.getDouble("Amount");
			
			Payment p = actual.get(i);
			boolean sameNumber = p.getCustomerNumber() == customerNumber;
			boolean sameAmount = p.getAmount() == amount;
			
			String cname = p.getCustomerName();
			boolean sameName = cname.equals(customerName);
			boolean haveSameValue = ( sameNumber && sameName && sameAmount);
					
			if( !(haveSameValue))
				return false;
			
			i++;
		}
		
		return true;
	}
	
	@Before
	public void Setup() {
		System.out.println("Running: Setup");
		
		orderData = new OrderData("root","Xixoxixo2010a");
		customerData = new CustomerData("root","Xixoxixo2010a", orderData);
		paymentData = new PaymentData("root","Xixoxixo2010a", customerData);
		baseQuery = new BaseQuery("root","Xixoxixo2010a");
	}
	
	//Build up tests
	@Test
	public void Can_retrieve_all_payments() throws SQLException{
		
		ArrayList<Payment> payments = paymentData.All();
		
		assertEquals(273,payments.size());
	}
	
	
	//Requirement 2
	//Customer payments above 10000 count test (using SQL query statement)
	@Test
	public void Can_count_all_payments_above_X() throws SQLException{
		
		ArrayList<Payment> payments = paymentData.PaymentAbove(100000.00);
		
		int expected = getDbCount("select count(*) as rowcount from payments where amount > 100000");
		assertEquals(expected,payments.size());
	}
	
	//Customer payments above $10000 test (using SQL query statement)
	@Test
	public void Can_retrieve_all_payments_above_X_ordered_by_amount_desc() throws SQLException{
		
		
		ArrayList<Payment> payments = paymentData.PaymentAbove(100000.00);
		
		String sql = "select p.customerNumber, c.customerName, p.amount from payments p inner join customers c on p.customerNumber = c.CustomerNumber where p.amount > 100000 order by p.amount desc";
		
		ResultSet expectedPaymentsRs = baseQuery.TestQuery(sql);
		
		assertTrue(SameData(expectedPaymentsRs,payments));
		
	}


	@After 
    public void TearDown() throws Exception {
        System.out.println("Running: tearDown");
        customerData.Close();
        paymentData.Close();
        orderData.Close();
    }

}
