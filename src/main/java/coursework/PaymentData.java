package coursework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PaymentData extends BaseQuery{

	private CustomerData customerData;
	
	
	//Initiates BaseQuery class (starts DB)
	public PaymentData(String uname, String pwd, CustomerData customerData) {
		super(uname, pwd);
		this.customerData = customerData;
		
	}
	
	
	//converts sql to java using ResultSet
	private Payment build(ResultSet rs) throws SQLException 
	{
		int customerNumber = rs.getInt("CustomerNumber");
		String checkNumber = rs.getString("checkNumber");
		Date paymentDate = rs.getDate("PaymentDate");
		double amount = rs.getDouble("Amount");
		
		Payment payment = new Payment(customerNumber, checkNumber, paymentDate, amount);
		
		return payment; 
	}
	
	
	//method used for getting all payments in DB 
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
	
	
	//closes java DB connection
	public void Close() {
		super.Close();
		
	}

	
	//method used to get customers with the same associated name
	private Customer getCustomer(int customerNumber, ArrayList<Customer> customers )
	{
		Customer customer = null;
		
		//filtering through all customers to check if the payment customer name is the same as the customer's
		for(Customer c : customers )
		{
			if (c.getCustomerNumber() == customerNumber)
			{
				customer = c;
				break;
			}
				
		}
		
		return customer;
	}
	
	
	//method used to create arrayList of payments with Payments above a certain amount
	public  ArrayList<Payment> PaymentAbove(double value) throws SQLException{
		
		ArrayList<Payment> result = new ArrayList<Payment>();
		ArrayList<Payment> payments = All();
		ArrayList<Customer> customers = customerData.All();
		
		for (Payment p : payments)
		{
			
			Customer c = getCustomer(p.getCustomerNumber(), customers);
			
			if(p.getAmount() > value) {
				Payment payment = new Payment(c, p);
				
				result.add(payment);
			}
		}
		
		//sort payments in descending order by amounts
		Collections.sort(result, new PaymentAmountSorter());
		Collections.reverse(result);
		return result;

	}
	
}
