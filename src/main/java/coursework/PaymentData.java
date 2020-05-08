package coursework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PaymentData extends BaseQuery{

	public PaymentData(String uname, String pwd) {
		super(uname, pwd);
	}
	
	private Payment build(ResultSet rs) throws SQLException 
	{
		int customerNumber = rs.getInt("CustomerNumber");
		String checkNumber = rs.getString("checkNumber");
		Date paymentDate = rs.getDate("PaymentDate");
		double amount = rs.getDouble("Amount");
	
		
		Payment payment = new Payment(customerNumber, checkNumber, paymentDate, amount);
		
		return payment; 
	}
	
	
	public ArrayList<Payment> All() throws SQLException {
		
		// fetch all rows for table (Customer)
		ResultSet rs = super.useTable("Payments");
		
		// filter out depending on this method criteria
		ArrayList<Payment> payments =  new ArrayList<Payment>();
		
		while(rs.next()) {
		    
			Payment payment = build(rs);
		 
			payments.add(payment);

		}
		return payments;
	}
	
	
	public  ArrayList<Payment> PaymentAbove(double value) throws SQLException{
		ArrayList<Payment> result = new ArrayList<Payment>();
		ArrayList<Payment> payments = All();
		
		for (Payment p : payments)
		{
			if(p.getAmount() > value) {
				result.add(p);
			}
		}
		return result;
	}
	
	
	public ArrayList<Payment> AllFor(int customerNumber) throws SQLException{
		
		// for all payments
		// find those that relate to this is customer number. (passed as argument)
		ArrayList<Payment> All = All();
		ArrayList<Payment> result = new ArrayList<Payment>();		
		for (Payment p : All) 
		{
			if (p.getCustomerNumber() == customerNumber) {
				result.add(p);
			}
		}
		return result;
	}
	
	
	
}
