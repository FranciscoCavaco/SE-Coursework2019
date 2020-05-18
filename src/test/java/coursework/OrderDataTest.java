package coursework;


import static org.junit.Assert.*;

import java.sql.*;
import java.util.*;

import org.junit.*;
import org.junit.Before;


public class OrderDataTest {
	
	private OrderData orderData = null;
	
	@Before
	public void Setup() {
		System.out.println("Running: Setup");
		
		orderData = new OrderData("root","Xixoxixo2010a");
	}

	@Test
	public void Can_retrieve_all_orders() throws SQLException{
		
		ArrayList<Order> orders = orderData.All();
		
		assertEquals(326,orders.size());
	}
	
	@Test
	public void Can_retrieve_all_orders_for_a_customer() throws SQLException{
		
		int customerNumber = 103;
		
		ArrayList<Order> orders = orderData.AllFor(customerNumber);
		
		assertEquals(3,orders.size());
	}
	

	@After 
    public void TearDown() throws Exception {
        System.out.println("Running: tearDown");
        orderData.Close();
    }

}
