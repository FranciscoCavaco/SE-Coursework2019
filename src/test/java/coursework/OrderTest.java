package coursework;


import static org.junit.Assert.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.junit.*;
import com.mysql.*;
import org.junit.Before;


public class OrderTest {

	@Test
	public void Can_calculate_order_timelapse() throws ParseException {
		Date dt2020Jan01 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
		Date dt2020Jan02 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02");
		Date dt2020Jan04 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-04");
		Date dt2020Jan05 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-05");
		Date dt2020Jan07 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-07");
		Date dt2020Jan09 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-09");
		
		
		Order o1 = new Order(1,dt2020Jan01,dt2020Jan01,dt2020Jan05, "A","comment 1", 103);
		Order o2 = new Order(2,dt2020Jan01,dt2020Jan01,dt2020Jan07, "A","comment 1", 103);
		
		int actual = o1.getShippingTimeLapse();
		int expected = 4;
		assertEquals(expected, actual);
		
		actual = o2.getShippingTimeLapse();
		expected = 6;
		assertEquals(expected, actual);
		
	}
}
