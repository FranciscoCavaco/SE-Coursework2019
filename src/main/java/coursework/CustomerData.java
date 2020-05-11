package coursework;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerData extends BaseQuery 
{
	private PaymentData paymentData;
	private OrderData orderData;

	public CustomerData(String uname, String pwd, PaymentData paymentData, OrderData orderData) {
		super(uname, pwd);
		this.paymentData = paymentData;
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
		
		Customer customer = new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, AddressLine1, AddressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit, null, orders);
		
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

//Apagar depois talvez dependendo de resposta
	public ArrayList<Customer> AllWithPaymentAmountAbove(double greaterThanAmount) throws SQLException {
		
		// get all customers
		ArrayList<Customer> result = new ArrayList<Customer>();
		ArrayList<Customer> customers = All();
		
		// filter for highest payment amount greater than greaterThanAmount
		for (Customer c : customers) {
			//if(c.getHighestPayment() > paymentData.PaymentAbove(greaterThanAmount)) {}
		}
		// order descending  by highest payment amount
		
		return result;
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
	
	public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] left = new int[mid];
	    int[] right = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        left[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        right[i - mid] = a[i];
	    }
	    mergeSort(left, mid);
	    mergeSort(right, n - mid);
	 
	    merge(a, left, right, mid, n - mid);
	}
	
	public static void merge(
			  int[] a, int[] l, int[] r, int left, int right) {
			  
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] >= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			            a[k++] = r[j++];
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }
			}

}
