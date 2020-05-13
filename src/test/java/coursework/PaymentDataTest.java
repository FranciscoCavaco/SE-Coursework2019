package coursework;


import static org.junit.Assert.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.junit.*;
import com.mysql.*;
import org.junit.Before;


public class PaymentDataTest {
	
	private CustomerData customerData = null;
	private PaymentData paymentData = null;
	private BaseQuery baseQuery = null;
	private OrderData orderData = null;
	
	@Before
	public void Setup() {
		System.out.println("Running: Setup");
		
		orderData = new OrderData("root","");
		customerData = new CustomerData("root","", orderData);
		paymentData = new PaymentData("root","", customerData);
		baseQuery = new BaseQuery("root","");
	}

	
	//requirement 2
	@Test
	public void Can_retrieve_all_payments() throws SQLException{
		
		ArrayList<Payment> payments = paymentData.All();
		
		assertEquals(273,payments.size());
	}
	
	private int getDbCount(String query) throws SQLException {
		ResultSet rs = baseQuery.TestQuery(query);
		rs.next();
		return rs.getInt("rowcount");	
	}
	
	@Test
	public void Can_retrieve_all_payments_above_X() throws SQLException{
		
		ArrayList<Payment> payments = paymentData.PaymentAbove(100000.00);
		
		int expected = getDbCount("select count(*) as rowcount from payments where amount > 100000");
		assertEquals(expected,payments.size());
	}


	@After 
    public void TearDown() throws Exception {
        System.out.println("Running: tearDown");
        customerData.Close();
        paymentData.Close();
        orderData.Close();
    }

}
