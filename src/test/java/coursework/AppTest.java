package coursework;

import static org.junit.Assert.assertEquals;

import java.sql.*;
import java.util.*;

import org.junit.*;
import com.mysql.*;
import org.junit.Before;


public class AppTest {
	
	private CustomerData customerData = null;
	private PaymentData paymentData = null;
	
	@Before
	public void Setup() {
		System.out.println("Running: Setup");
		
		paymentData = new PaymentData("root","");
		customerData = new CustomerData("root","", paymentData);
	}
	
	@Test
	public void Can_retrieve_all_customers() throws SQLException{
		
		ArrayList<Customer> customers = customerData.All();
		
		assertEquals(122,customers.size());
		
	}
	
	@Test
	public void Can_retrieve_all_payments() throws SQLException{
		
		ArrayList<Payment> payments = paymentData.All();
		
		assertEquals(273,payments.size());
	}
	
	@Test
	public void Can_retrieve_all_payments_for_a_customer() throws SQLException{
		
		int customerNumber = 103;
		
		ArrayList<Payment> payments = paymentData.AllFor(customerNumber);
		
		assertEquals(3,payments.size());
		
	}
	
	
	// requirement 1
	@Test
	public void can_retrieve_customers_without_sales_representative() throws SQLException {
		ArrayList<Customer> customers = customerData.AllWithoutSalesRepresentative();
		assertEquals(22,customers.size());
	}
	
	//requirement 2
	@Test
	public void can_retrieve_customers_with_highest_payment_amount() throws SQLException {
		ArrayList<Customer> customers = customerData.AllWithPaymentAmountAbove(100000.00D);
		assertEquals(22,customers.size());
	}
	
	@After 
    public void TearDown() throws Exception {
        System.out.println("Running: tearDown");
        customerData.Close();
        paymentData.Close();
    }

}
