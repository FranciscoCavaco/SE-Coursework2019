package coursework;


import static org.junit.Assert.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.junit.*;

public class CustomerDataTest {
	
	private CustomerData customerData = null;
	private OrderData orderData = null;
	private BaseQuery baseQuery = null;
	
	private boolean SameDataReq1(ResultSet expectedRs, ArrayList<Customer> actual) throws SQLException
	{
		int i = 0;
		while(expectedRs.next()) {
			
			String customerName = expectedRs.getString("customerName");
			String city = expectedRs.getString("City");
			
			Customer c = actual.get(i);
			boolean sameCity = c.getCity().equals(city);
			String cname = c.getCustomerName();
			boolean sameName = cname.equals(customerName);
			boolean haveSameValue = ( sameName && sameCity);
					
			if( !(haveSameValue))
				return false;
			
			i++;
		}
		
		return true;
	}
	
	private boolean SameDataReq3(ResultSet expectedRs, ArrayList<Customer> actual) throws SQLException
	{
		int i = 0;
		double delta = 0.001;
		while(expectedRs.next()) {
			double average = expectedRs.getDouble("average");
		
			Customer c = actual.get(i);
			double cAverage = c.getOrderTimeLapseAverage();
			boolean sameAverage = Math.abs(cAverage - average) <= delta;
			
			boolean haveSameValue = (sameAverage);
					
			if( !(haveSameValue))
				return false;
			
			i++;
		}
		return true;
	}
	
	
	@Before
	public void Setup() {
		System.out.println("Running: Setup");
		
		orderData = new OrderData("root","");
		customerData = new CustomerData("root","", orderData);
		baseQuery = new BaseQuery("root","");
	}
	
	//Build up tests
	@Test
	public void Can_retrieve_all_customers() throws SQLException{
		
		ArrayList<Customer> customers = customerData.All();
		
		assertEquals(122,customers.size());
		
	}
	
	//Requirement 1
	//Customer without sales rep count test
	@Test
	public void can_count_customers_without_sales_representative() throws SQLException {
		ArrayList<Customer> customers = customerData.AllWithoutSalesRepresentative();
		assertEquals(22,customers.size());
	}
	
	
	//Customer without sales rep SQL query test
	@Test
	public void Can_retrieve_customers_without_sales_representative() throws SQLException{
		
		
		ArrayList<Customer> customers = customerData.AllWithoutSalesRepresentative();
		
		String sql = "select customerName, City from customers where salesRepEmployeeNumber is NULL";
		
		ResultSet expectedCustomersRs = baseQuery.TestQuery(sql);
		
		assertTrue(SameDataReq1(expectedCustomersRs,customers));
	}
	
	
	
	//requirement 3
	//Customer timelapse Count test
	@Test
	public void Can_retrieve_avg_order_time_lapse_for_a_customer() throws SQLException{
		
		int customerNumber = 103;
		
		Customer customer = customerData.For(customerNumber);
		
		assertEquals( 2.3333 ,customer.getOrderTimeLapseAverage(), 0.0001);
	}
	
	
	//Customer timelapse Order sort SQL query test
	@Test
	public void can_sort_orders_by_time_lapse_sqltest() throws SQLException{
		
		
		ArrayList<Customer> customers = customerData.AllWithOrders();
		customerData.SortForAverageTimeLapse(customers);
		
		String sql = "Select  o.customerNumber, c.customerName,avg(datediff(o.shippedDate, o.OrderDate)) as average from orders o inner join customers c on o.customerNumber = c.customerNumber "
				+ "where o.shippeddate is not NULL Group by o.customernumber order by average desc;";
		
		ResultSet expectedCustomersRs = baseQuery.TestQuery(sql);
		
		assertTrue(SameDataReq3(expectedCustomersRs,customers));
		
	}

	
	//Customer timelapse Order sort using mock data
	@Test
	public void can_sort_orders_by_time_lapse_mock() throws ParseException {
		
		// customer 1
		// ----------
		Date dt2020Jan01 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
		Date dt2020Jan02 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02");
		Date dt2020Jan04 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-04");
		Date dt2020Jan05 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-05");
		Date dt2020Jan07 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-07");
		Date dt2020Jan09 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-09");
		
		
		Order o1 = new Order(1,dt2020Jan01,dt2020Jan01,dt2020Jan05, "A","comment 1", 103);
		Order o2 = new Order(2,dt2020Jan01,dt2020Jan01,dt2020Jan07, "A","comment 1", 103);
		
		// 4 + 6 / 2
		// expected avg = 5
		
		ArrayList<Order> orders1 = new ArrayList<Order>();
		orders1.add(o1);
		orders1.add(o2);
		Customer c1 = new Customer(103,"Fran1", orders1 );
				

		// customer 2
		// ----------
		Order o3 = new Order(3,dt2020Jan01,dt2020Jan01,dt2020Jan09, "A","comment 1", 104);
		Order o4 = new Order(4,dt2020Jan01,dt2020Jan01,dt2020Jan07, "A","comment 1", 104);
		
		// expected avg :  7
		
		ArrayList<Order> orders2 = new ArrayList<Order>();
		orders2.add(o3);
		orders2.add(o4);
		Customer c2 = new Customer(104,"Fran1", orders2 );
		

		// customer 3
		// ----------
		Order o5 = new Order(5,dt2020Jan01,dt2020Jan01,dt2020Jan02, "A","comment 1", 105);
		Order o6 = new Order(6,dt2020Jan01,dt2020Jan01,dt2020Jan04, "A","comment 1", 105);
		
		// expected avg : 2
		
		ArrayList<Order> orders3 = new ArrayList<Order>();
		orders3.add(o5);
		orders3.add(o6);
		Customer c3 = new Customer(105,"Fran1", orders3 );
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		customerData.SortForAverageTimeLapse(customers);
		
		// assert items are in the right order within array.
		
		// expected (with reversion) 7 ; 5 ; 2 (AVG)
		ArrayList<Customer> expected = new ArrayList<Customer>();
		expected.add(c2);
		expected.add(c1);
		expected.add(c3);
		
		int c1cn = 103;
		int c2cn = 104;
		int c3cn = 105;
		int ac0 = customers.get(0).getCustomerNumber();
		int ac1 = customers.get(1).getCustomerNumber();
		int ac2 = customers.get(2).getCustomerNumber();
		
		assertTrue("This is not expected customer...", c2cn == ac0);
		assertTrue("This is not expected customer...", c1cn == ac1);
		assertTrue("This is not expected customer...", c3cn == ac2);
	
	}
	
	

	@After 
    public void TearDown() throws Exception {
        System.out.println("Running: tearDown");
        customerData.Close();
        orderData.Close();
    }

}
