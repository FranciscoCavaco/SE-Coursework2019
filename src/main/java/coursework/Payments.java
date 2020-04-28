package coursework;

import java.util.*;

public class Payments {
	private int CustomerNumber;
	private String CheckNumber;
	private Date PaymentDate;
	private double Amount;
	
	public Payments(int CustomerNumber, String CheckNumber, Date PaymentDate, double Amount) {
		super();
		this.CustomerNumber = CustomerNumber;
		this.CheckNumber = CheckNumber;
		this.PaymentDate = PaymentDate;
		this.Amount = Amount;
	}

	public int getCustomerNumber() {
		return CustomerNumber;
	}

	public String getCheckNumber() {
		return CheckNumber;
	}

	public Date getPaymentDate() {
		return PaymentDate;
	}

	public double getAmount() {
		return Amount;
	}	

}
