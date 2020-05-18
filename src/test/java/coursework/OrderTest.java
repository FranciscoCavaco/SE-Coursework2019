package coursework;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.*;


public class OrderTest {

	@Test
	public void Can_calculate_order_timelapse() throws ParseException {
		LocalDate dt2020Jan01 = LocalDate.parse("2020-01-01");
		LocalDate dt2020Jan05 = LocalDate.parse("2020-01-05");
		LocalDate dt2020Jan07 = LocalDate.parse("2020-01-07");
		Order o1 = new Order(1,dt2020Jan01,dt2020Jan01,dt2020Jan05, "A","comment 1", 103);
		Order o2 = new Order(2,dt2020Jan01,dt2020Jan01,dt2020Jan07, "A","comment 1", 103);
		
		long actual = o1.getShippingTimeLapse();
		long expected = 4;
		assertEquals(expected, actual);
		
		actual = o2.getShippingTimeLapse();
		expected = 6;
		assertEquals(expected, actual);
		
	}
}
