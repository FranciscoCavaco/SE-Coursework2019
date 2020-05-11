package coursework;

import java.util.Comparator;
 
public class OrderAverageTimeLapseSorter  implements Comparator<Customer>{
 
	public int compare(Customer c1, Customer c2) {
		if (c1.getOrderTimeLapseAverage() == c2.getOrderTimeLapseAverage())
			return 0;
		else if(c1.getOrderTimeLapseAverage() > c2.getOrderTimeLapseAverage())
			return 1;
		else
			return -1;
		
	}
}


