package coursework;

import java.util.*;

public class Payment {
	
	//Attribute declaration
	private int customerNumber;
	private String customerName;
	private String checkNumber;
	private Date paymentDate;
	private double amount;
	
	
	//Constructor for Testing
	public Payment(int CustomerNumber, String CheckNumber, double Amount) {
		super();
		this.customerNumber = CustomerNumber;
		this.checkNumber = CheckNumber;
		this.amount = Amount;
	}
	
	//Constructor for Req 2
	public Payment(Customer c, Payment p) {
		super();
		this.customerNumber = p.getCustomerNumber();
		this.customerName = c.getCustomerName();
		this.amount = p.getAmount();
	}
	
	
	//Constructor with all attributes
	public Payment(int CustomerNumber, String CheckNumber, Date PaymentDate, double Amount) {
		super();
		this.customerNumber = CustomerNumber;
		this.checkNumber = CheckNumber;
		this.paymentDate = PaymentDate;
		this.amount = Amount;
	}

	
	//getters
	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public double getAmount() {
		return this.amount;
	}

	
	//method used to print Second Requirement in console
	public void printMeConsole() {
		System.out.printf("%d | %s | $ %.2f \n\r", this.getCustomerNumber(), this.getCustomerName(),this.getAmount());
	}

}
