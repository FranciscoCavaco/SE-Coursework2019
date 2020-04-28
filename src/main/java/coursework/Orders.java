package coursework;

import java.util.*;

public class Orders {
	private int OrderNumber;
	private Date OrderDate;
	private Date RequiredDate;
	private Date ShippedDate;
	private String Status;
	private String Comments;
	private int CustomerNumber;
	
	public Orders (int OrderNumber, Date OrderDate, Date RequiredDate, Date ShippedDate, String Status, String Comments, int CustomerNumber) {
		super();
		this.OrderNumber = OrderNumber;
		this.OrderDate = OrderDate;
		this.RequiredDate = RequiredDate;
		this.ShippedDate = ShippedDate;
		this.Status = Status;
		this.Comments = Comments;
		this.CustomerNumber = CustomerNumber;
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public Date getRequiredDate() {
		return RequiredDate;
	}

	public Date getShippedDate() {
		return ShippedDate;
	}

	public String getStatus() {
		return Status;
	}

	public String getComments() {
		return Comments;
	}

	public int getCustomerNumber() {
		return CustomerNumber;
	}

}
