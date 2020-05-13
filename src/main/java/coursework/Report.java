package coursework;

import java.util.ArrayList;

public class Report {
	
	//Printing all Requirements arrays
	public void printCustomerWithoutSalesRepresentative(ArrayList<Customer> customers) 
	{

		System.out.printf(" Requirement 1: Customers without Sales Representative : rowcount %d \n\r",customers.size() );
		System.out.println("-------------------------------------------------------");
		System.out.println("Customer Name 	| 	City				");
		System.out.println("-------------------------------------------------------");
		
		for(Customer c : customers){
			c.printWithoutSaleRepConsole();
		}

	}
	
	public void printPaymentsAbove(ArrayList<Payment> payments) 
	{
		System.out.println();
		System.out.printf(" Requirement 2: Customers with Payments above $100000 : rowcount %d \n\r", payments.size() );
		System.out.println("-------------------------------------------------------");
		System.out.println("Customer Number	|	Customer Name	| $ Amount	");
		System.out.println("-------------------------------------------------------");
		
		for(Payment p : payments){
			p.printMeConsole();
		}
	}
	
	public void printAverageOrderTime(ArrayList<Customer> orders) 
	{		
		System.out.println();
		System.out.printf(" Requirement 3: Average time between order date and ship date for each Customer : rowcount %d \n\r", orders.size() );
		System.out.println("-------------------------------------------------------");
		System.out.println("Customer Number	|	Customer Name	| Average order time	");
		System.out.println("-------------------------------------------------------");
		
		for(Customer o : orders){
			o.printAverageOrderTimeConsole();
		}
	}
}
