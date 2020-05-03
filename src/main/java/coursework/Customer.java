package coursework;


public class Customer {
	private int CustomerNumber;
	private String CustomerName;
	private String ContactLastName;
	private String ContactFirstName;
	private String Phone;
	private String AddressLine1;
	private String AddressLine2;
	private String City;
	private String State;
	private String PostalCode;
	private String Country;
	private int SalesRepEmployeeNumber;
	private double CreditLimit;
	
	public Customer(int CustomerNumber, String CustomerName, String ContactLastName, String ContactFirstName, String Phone, String AddressLine1, 
			String AddressLine2, String City, String State, String PostalCode, String Country, int SalesRepEmployeeNumber, double CreditLimit) {
		// Super here for convention
		super();
		this.CustomerNumber = CustomerNumber;
		this.CustomerName = CustomerName;
		this.ContactLastName = ContactLastName;
		this.ContactFirstName = ContactFirstName;
		this.Phone = Phone;
		this.AddressLine1 = AddressLine1;
		this.AddressLine2 = AddressLine2;
		this.City = City;
		this.State = State;
		this.PostalCode = PostalCode;
		this.Country = Country;
		this.SalesRepEmployeeNumber = SalesRepEmployeeNumber;
		this.CreditLimit = CreditLimit;
	}

	public int getCustomerNumber() {
		return CustomerNumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public String getContactLastName() {
		return ContactLastName;
	}

	public String getContactFirstName() {
		return ContactFirstName;
	}

	public String getPhone() {
		return Phone;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public String getCity() {
		return City;
	}

	public String getState() {
		return State;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public String getCountry() {
		return Country;
	}

	public int getSalesRepEmployeeNumber() {
		return SalesRepEmployeeNumber;
	}

	public double getCreditLimit() {
		return CreditLimit;
	}
	

}
