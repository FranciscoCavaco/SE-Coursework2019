package coursework;

import java.util.ArrayList;

public class Customer {
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
	
	
	public Customer(int CustomerNumber, String CustomerName, String ContactLastName, String ContactFirstName, String Phone, String AddressLine1, 
			String AddressLine2, String City, String State, String PostalCode, String Country, int SalesRepEmployeeNumber, double CreditLimit, ArrayList<Payment> payments) {
		// Super here for convention
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
	
	public Payment getHighestPayment() {
		Payment highest = null;
		
		for(Payment p : payments) 
		{
			if(p.getAmount() > highest.getAmount()) {
				highest = p;
			}
			
		}
		
		return highest;
	}
	

}
