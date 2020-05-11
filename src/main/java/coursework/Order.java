package coursework;

import java.util.*;

public class Order {
	private int orderNumber;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
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
	
	public int getDiffDate(Order o){
		int diff = 0;
		long convertToDay = 86400000;
		diff = (int) ((o.getShippedDate().getTime())/convertToDay - (o.getOrderDate().getTime())/convertToDay);
		return diff;
	}
	/*
	public int getAverage(int numOfOrders){
		int diff = 0;
		long convertToDay = 86400000;
		for(Order o : orders)
		{
			diff = diff + (int) ((o.getShippedDate().getTime())/convertToDay - (o.getOrderDate().getTime())/convertToDay);
		}
		return diff/numOfOrders;
	}


	public int compareTo(Order o) {
		
		if (this.getDiffDate(o) == 0 )
			return 0;
		else if(this.getDiffDate(o) > 0)
			return 1;
		else
			return -1;
	}
	
	*/

}
