package coursework;

import java.util.*;

public class Order {
	
	//Attribute declaration
	private int orderNumber;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	
	//Constructor
	public Order (int OrderNumber, Date OrderDate, Date RequiredDate, Date ShippedDate, String Status, String Comments, int CustomerNumber) {
		super();
		this.orderNumber = OrderNumber;
		this.orderDate = OrderDate;
		this.requiredDate = RequiredDate;
		this.shippedDate = ShippedDate;
		this.status = Status;
		this.comments = Comments;
		this.customerNumber = CustomerNumber;
	}

	
	//getters
	public int getOrderNumber() {
		return this.orderNumber;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public Date getRequiredDate() {
		return this.requiredDate;
	}

	public Date getShippedDate() {
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
	public int getShippingTimeLapse(){
		int diff = 0;
		long convertToDay = 86400000;
		diff = (int) ((this.getShippedDate().getTime())/convertToDay - (this.getOrderDate().getTime())/convertToDay);
		return diff;
	}

}
