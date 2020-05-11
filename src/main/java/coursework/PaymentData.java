package coursework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

public class PaymentData extends BaseQuery{

	private CustomerData customerData;
	
	public PaymentData(String uname, String pwd, CustomerData customerData) {
		super(uname, pwd);
		this.customerData = customerData;
		
	}
	
	private Payment build(ResultSet rs) throws SQLException 
	{
		int customerNumber = rs.getInt("CustomerNumber");
		String checkNumber = rs.getString("checkNumber");
		Date paymentDate = rs.getDate("PaymentDate");
		double amount = rs.getDouble("Amount");
	
		Customer customer  = customerData.For(customerNumber);
		Payment payment = new Payment(customerNumber, checkNumber, paymentDate, amount, customer.getCustomerName());
		
		return payment; 
	}
	
	
	public ArrayList<Payment> All() throws SQLException {
		
		ArrayList<Payment> payments =  new ArrayList<Payment>();
		
		try {
			// fetch all rows for table (Payments)
			ResultSet rs = super.useTable("Payments");
		
			// filter out depending on this method criteria
		
		
			while(rs.next()) {
		    
				Payment payment = build(rs);
		 
				payments.add(payment);

			}
		}
		catch(Exception ex) {
			System.out.println("unable retrieve payment ..." + ex.getMessage());			
		}
		return payments;
	}
	
	public void Close() {
		super.Close();
		
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
		
		//Collections.sort(customers, new OrderAverageTimeLapseSorter());
		//Collections.reverse(customers);
		return result;
	}
	

//nao presta
//	public ArrayList<Payment> AllFor(int customerNumber) throws SQLException{
//		
//		// for all payments
//		// find those that relate to this is customer number. (passed as argument)
//		ArrayList<Payment> All = All();
//		ArrayList<Payment> result = new ArrayList<Payment>();		
//		for (Payment p : All) 
//		{
//			if (p.getCustomerNumber() == customerNumber) {
//				result.add(p);
//			}
//		}
//		return result;
//	}
	
	
	
}
