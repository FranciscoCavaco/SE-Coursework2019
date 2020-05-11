package coursework;

import java.util.ArrayList;

public class Customer implements Comparable<Customer>  {
	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private double creditLimit;
	private ArrayList<Payment> payments;
	private ArrayList<Order> orders;
	
	//Requirement 2
	public Customer(int CustomerNumber, String CustomerName, String City) {
		super();
	}
	
	//Requirement 3
	public Customer(int CustomerNumber, String CustomerName, ArrayList<Order> orders) {
		super();
		this.customerNumber = CustomerNumber;
		this.customerName = CustomerName;
		this.orders = orders;
	}
	
		
	public Customer(int CustomerNumber, String CustomerName, String ContactLastName, String ContactFirstName, String Phone, String AddressLine1, 
			String AddressLine2, String City, String State, String PostalCode, String Country, int SalesRepEmployeeNumber, double CreditLimit, ArrayList<Payment> payments, ArrayList<Order> orders) {
		super();
		this.customerNumber = CustomerNumber;
		this.customerName = CustomerName;
		this.contactLastName = ContactLastName;
		this.contactFirstName = ContactFirstName;
		this.phone = Phone;
		this.addressLine1 = AddressLine1;
		this.addressLine2 = AddressLine2;
		this.city = City;
		this.state = State;
		this.postalCode = PostalCode;
		this.country = Country;
		this.salesRepEmployeeNumber = SalesRepEmployeeNumber;
		this.creditLimit = CreditLimit;
		this.payments = payments;
		this.orders = orders;
		
	}

	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public String getContactLastName() {
		return this.contactLastName;
	}

	public String getContactFirstName() {
		return this.contactFirstName;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public String getCountry() {
		return this.country;
	}

	public int getSalesRepEmployeeNumber() {
		return this.salesRepEmployeeNumber;
	}

	public double getCreditLimit() {
		return this.creditLimit;
	}
	
	public ArrayList<Payment> getPayments() {
		return this.payments;
	}
	
	public ArrayList<Order> getOrders() {
		return this.orders;
	}
	
	public int getOrderCount() {
		if (orders == null)
		{
			return 0;
		}
		else
		{
			return orders.size();
		}
	}
	
	public double getOrderTimeLapseAverage() {
		
		double orderTotal = 0.0;
		for (Order o : orders) {
			orderTotal += o.getDiffDate(o);
		}
		double average = orderTotal/orders.size();
		return average;
	}

	public int compareTo(Customer otherCustomer) {
		
		if (this.getCustomerNumber() == otherCustomer.getCustomerNumber() )
			return 0;
		else if(this.getCustomerNumber() > otherCustomer.getCustomerNumber() )
			return 1;
		else
			return -1;
	}
	
	
	

//	public Payment getHighestAverage() {
//		Payment highest = null;
//		
//		for(Order o : orders) 
//		{
//			if(o.getAmount() > highest.getAmount()) {
//				highest = p;
//			}
//			
//		}
//		return highest;
//	}
	

}
