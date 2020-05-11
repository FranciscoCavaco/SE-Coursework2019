package coursework;

import java.util.*;

public class Payment  implements Comparable<Payment>{ 
	private int customerNumber;
	private String customerName;
	private String checkNumber;
	private Date paymentDate;
	private double amount;
	
	public Payment(int CustomerNumber, String CheckNumber, Date PaymentDate, double Amount, String CustomerName) {
		super();
		this.customerNumber = CustomerNumber;
		this.checkNumber = CheckNumber;
		this.paymentDate = PaymentDate;
		this.amount = Amount;
		this.customerName = CustomerName;
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

	public int compareTo(Payment p) {
		
		return 0;
	}	

}
