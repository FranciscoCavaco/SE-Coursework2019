package coursework;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReportConsole {

	public static void main(String[] args) throws SQLException {
		
		Report report = new Report();
//		String user = args[0];
//		String password = args[1];
		
		String user = "root";
		String password = "";
		
		//main where we print all Requirement Arrays
		OrderData orderData = new OrderData(user,password);
		CustomerData customerData = new CustomerData(user,password, orderData);
		PaymentData paymentData = new PaymentData(user,password, customerData);
		
		// R1
		ArrayList<Customer> customers = customerData.AllWithoutSalesRepresentative();
		report.printCustomerWithoutSalesRepresentative(customers);
		
		//R2
		ArrayList<Payment> payments = paymentData.PaymentAbove(100000);
		report.printPaymentsAbove(payments);
		
		//R3
		ArrayList<Customer> orders = customerData.AllWithOrders();
		report.printAverageOrderTime(orders);
	}
	
	

}
