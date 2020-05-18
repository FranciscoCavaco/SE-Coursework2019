package coursework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Order {
	
	//Attribute declaration
	private int orderNumber;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	
	//Constructor
	public Order (int OrderNumber, LocalDate dt2020Jan01, LocalDate dt2020Jan012, LocalDate dt2020Jan05, String Status, String Comments, int CustomerNumber) {
		super();
		this.orderNumber = OrderNumber;
		this.orderDate = dt2020Jan01;
		this.requiredDate = dt2020Jan012;
		this.shippedDate = dt2020Jan05;
		this.status = Status;
		this.comments = Comments;
		this.customerNumber = CustomerNumber;
	}

	
	//getters
	public int getOrderNumber() {
		return this.orderNumber;
	}

	public LocalDate getOrderDate() {
		return this.orderDate;
	}

	public LocalDate getRequiredDate() {
		return this.requiredDate;
	}

	public LocalDate getShippedDate() {
		return this.shippedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public String getComments() {
		return this.comments;
	}

	public int getCustomerNumber() {
		return this.customerNumber;
	}
	
	
	//calculates time between order date and shipping data
	public long getShippingTimeLapse(){
		
		// note: issue with daylight savings require a more robust handling of dates. not enought to datediff it and divide by number of days...
		LocalDate start = this.getOrderDate();
		LocalDate end = this.getShippedDate();
		long result = ChronoUnit.DAYS.between( start, end);
		
		return result;
	}

}
