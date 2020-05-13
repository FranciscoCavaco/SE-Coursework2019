package coursework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class OrderData extends BaseQuery{
	
	
	//Initiates BaseQuery class (starts DB) 
	public OrderData(String uname, String pwd) {
		super(uname, pwd);
	}
	
	
	//converts sql to java using ResultSet
	private Order build(ResultSet rs) throws SQLException
	{
		int orderNumber = rs.getInt("OrderNumber");
		Date orderDate = rs.getDate("OrderDate");
		Date requiredDate = rs.getDate("RequiredDate");
		Date shippedDate = rs.getDate("ShippedDate");
		String status = rs.getString("Status");
		String comments = rs.getString("Comments");
		int customerNumber = rs.getInt("CustomerNumber");
		
		
		Order order = new Order(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
		
		return order;
	}
	
	
	//method used for getting all orders in DB 
	public ArrayList<Order> All() throws SQLException{
		
		//fetch all rows for table (Orders)
		ResultSet rs = super.useTable("Orders");
		
		//filter out depending on this method criteria
		ArrayList<Order> orders = new ArrayList<Order>();
		
		while(rs.next()) {
			
			Order order = build(rs);
			
			orders.add(order);
			
		}
		return orders;
	}
	
	
	//used for joining orders table with customers table
	public ArrayList<Order> AllFor(int customerNumber) throws SQLException{
		
		//for all orders
		//find those that relate to this customer number
		ArrayList<Order> All = All();
		ArrayList<Order> result = new ArrayList<Order>();
		for (Order o : All)
		{
			if (o.getCustomerNumber() == customerNumber) {
				result.add(o);
			}
		}
		return result;
	}

}
