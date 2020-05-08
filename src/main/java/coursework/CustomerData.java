package coursework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerData extends BaseQuery 
{
	private PaymentData paymentData;

	public CustomerData(String uname, String pwd, PaymentData paymentData) {
		super(uname, pwd);
		this.paymentData = paymentData;
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
	
		ArrayList<Payment> payments = paymentData.AllFor(customerNumber);
		
		Customer customer = new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, AddressLine1, AddressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit, payments);
		
		return customer; 
	}
	
	public ArrayList<Customer> All() throws SQLException {
		
		// fetch all rows for table (Customer)
		ResultSet rs = super.useTable("Customers");
		
		// filter out depending on this method criteria
		ArrayList<Customer> customers =  new ArrayList<Customer>();
		
		while(rs.next()) {
		    
			Customer customer = build(rs);
		 
			customers.add(customer);

		}
		return customers;
		
	}
	
	public ArrayList<Customer> AllWithoutSalesRepresentative() throws SQLException {
		
		ArrayList<Customer> result =  new ArrayList<Customer>();
		ArrayList<Customer> customers = All();
		
		for (Customer c : customers)
		{
			
			if(c.getSalesRepEmployeeNumber() == 0) {
				result.add(c);
			}
		}
		
		
		return result;
	}

	public void Close() {
		super.Close();
		
	}


	public ArrayList<Customer> AllWithPaymentAmountAbove(double greaterThanAmount) throws SQLException {
		
		// get all customers
		//ArrayList<Customer> result = new ArrayList<Customer>();
		//ArrayList<Customer> customers = All();
		
		// filter for highest payment amount greater than greaterThanAmount
		//for (Customer c : customers) {
			//if(c.getHighestPayment() > paymentData.PaymentAbove(100000))
		//}
		// order descending  by highest payment amount
		
		// return result
		return null;
	}


}
