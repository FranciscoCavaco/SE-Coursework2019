package coursework;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerData extends BaseQuery 
{
	private OrderData orderData;

	public CustomerData(String uname, String pwd, OrderData orderData) {
		super(uname, pwd);
		this.orderData = orderData;
	}
	
	
	private Customer build(ResultSet rs) throws SQLException 
	{
		int customerNumber = rs.getInt("CustomerNumber");
		String customerName = rs.getString("CustomerName");
		String contactLastName = rs.getString("ContactLastName");
		String contactFirstName = rs.getString("ContactFirstName");
		String phone = rs.getString("Phone");
		String AddressLine1 = rs.getString("AddressLine1");
		String AddressLine2 = rs.getString("AddressLine2");
		String city = rs.getString("City");
		String state = rs.getString("State");
		String postalCode = rs.getString("PostalCode");
		String country = rs.getString("Country");
		int salesRepEmployeeNumber = rs.getInt("SalesRepEmployeeNumber");
		double creditLimit = rs.getDouble("CreditLimit");
	
		
		ArrayList<Order> orders = orderData.AllFor(customerNumber);
		
		Customer customer = new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, AddressLine1, AddressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit, orders);
		
		return customer; 
	}
	
	public ArrayList<Customer> All() throws SQLException {
		
		ArrayList<Customer> customers =  new ArrayList<Customer>();
		
		try {
			// fetch all rows for table (Customer)
			ResultSet rs = super.useTable("Customers");
			
			// filter out depending on this method criteria
					
			while(rs.next()) {
			    
				Customer customer = build(rs);
			 
				customers.add(customer);
	
			}
		}
		catch(Exception ex){
			System.out.println("unable retrieve customer ..." + ex.getMessage());
		}
		return customers;
		
	}
	
	public ArrayList<Customer> AllWithoutSalesRepresentative() throws SQLException {
		
		ArrayList<Customer> result =  new ArrayList<Customer>();
		ArrayList<Customer> customers = All();
		
		for (Customer customer : customers)
		{
			
			if(customer.getSalesRepEmployeeNumber() == 0) {
				result.add(customer);
			}
		}
		
		
		return result;
	}

	public void Close() {
		super.Close();
		
	}
	
	
	public ArrayList<Customer> AllWithOrders() throws SQLException {
		
		//get all customers
		ArrayList<Customer> result = new ArrayList<Customer>();
		ArrayList<Customer> customers = All();
		
		for (Customer customer : customers) {
			
			if (customer.getOrderCount() > 0)
			{
				result.add(customer);
			}
			
		}
		
		return result;
	}
	
	public Customer For(int customerNumber) throws SQLException {
		
		Customer customer = null;
		//get all customers
		
		try 
		{
			ArrayList<Customer> customers = All();
			// filter for a specific customer
			for (Customer c : customers) {
				
				if (c.getCustomerNumber() == customerNumber)
				{			
					customer = c;
					break;
				
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("unable retrieve customer ..." + ex.getMessage());
		}
		
		return customer;
	}
	
	public void SortForAverageTimeLapse(ArrayList<Customer> customers ) {
		Collections.sort(customers, new OrderAverageTimeLapseSorter());
		Collections.reverse(customers);
	}

}
