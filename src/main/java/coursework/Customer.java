package coursework;

import java.util.ArrayList;


public class Customer   {
	
	//attribute declaration
	private int customerNumber;
	private String customerName;
	private String city;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private double creditLimit;
	
	private ArrayList<Payment> payments;
	private ArrayList<Order> orders;
	
	//Constructor (with attributes needed for Req 1)
	public Customer(int CustomerNumber, String CustomerName, String City) {
		super();
	}
	
	//Constructor (with attributes needed for Req 3)
	public Customer(int CustomerNumber, String CustomerName, ArrayList<Order> orders) {
		super();
		this.customerNumber = CustomerNumber;
		this.customerName = CustomerName;
		this.orders = orders;
	}
	
	//Constructor (with all attributes)
	public Customer(int CustomerNumber, String CustomerName, String ContactLastName, String ContactFirstName, String Phone, String AddressLine1, 
			String AddressLine2, String City, String State, String PostalCode, String Country, int SalesRepEmployeeNumber, double CreditLimit, ArrayList<Order> orders) {
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
		this.orders = orders;
		
	}

	
	//getters
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
	
	public ArrayList<Order> getOrders() {
		return this.orders;
	}
	
	
	//gets size of Order arraylist
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
	
	
	//Calculates average time from Order date and Ship date per specific customer (used for Req. 3)
	public double getOrderTimeLapseAverage() {
		
		int orderSize = 0;
		
		double orderTotal = 0.0;
		for (Order o : orders) {
			if(o.getShippedDate() != null && o.getOrderDate() != null)
			{
				orderTotal += o.getShippingTimeLapse();
				orderSize++;	
			}
		}
		
		double average = orderTotal/orderSize;
		
		return average;		
	}

	
	//method used to print First Requirement in console
	public void printWithoutSaleRepConsole() {
		System.out.printf("%s | %s \n\r", this.getCustomerName(),this.getCity());
	}
	
	
	//method used to print Third Requirement in console
	public void printAverageOrderTimeConsole() {
		System.out.printf("%d | %s | %.2f days \n\r", this.getCustomerNumber(), this.getCustomerName(),this.getOrderTimeLapseAverage());
	}
	

}
