package coursework;

import java.util.*;

public class Payment {
	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private double amount;
	
	public Payment(int CustomerNumber, String CheckNumber, Date PaymentDate, double Amount) {
		super();
		this.customerNumber = CustomerNumber;
		this.checkNumber = CheckNumber;
		this.paymentDate = PaymentDate;
		this.amount = Amount;
	}

	public int getCustomerNumber() {
		return this.customerNumber;
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

}
