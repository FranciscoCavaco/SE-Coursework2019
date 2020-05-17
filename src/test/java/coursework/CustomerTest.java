package coursework;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.junit.*;


public class CustomerTest {

	@Test
	public void Can_return_average_order_timelapse() throws ParseException {
		Date dt2020Jan01 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
		Date dt2020Jan05 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-05");
		Date dt2020Jan07 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-07");
		Order o1 = new Order(1,dt2020Jan01,dt2020Jan01,dt2020Jan05, "A","comment 1", 103);
		Order o2 = new Order(2,dt2020Jan01,dt2020Jan01,dt2020Jan07, "A","comment 1", 103);
		
		// 4 + 6 / 2
		// expected avg = 5
		
		ArrayList<Order> orders1 = new ArrayList<Order>();
		orders1.add(o1);
		orders1.add(o2);
		Customer c1 = new Customer(103,"Fran1", orders1 );
		
		double actual = c1.getOrderTimeLapseAverage();
		double expected = 5.0;
		
		assertEquals(expected, actual, 0.0);
		
	}
}
