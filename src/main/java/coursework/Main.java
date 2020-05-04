package coursework;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		CustomerData customerData = new CustomerData("root", "pwd");
		
		if (customerData != null) {
			System.out.println("yay");
		}
		
		// test 1 , my "All without Sales Rep" query method works.
		try {
			ResultSet rs = customerData.AllWithoutSalesRep();
			
		}
		catch(Exception ex) {
			System.out.println("nay");
		}

	}
}
