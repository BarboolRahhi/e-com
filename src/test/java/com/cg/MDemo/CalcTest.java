package com.cg.MDemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.cg.MDemo.CalcService;



public class CalcTest {

	@Test
	@Tag("dev")
	@Tag("prod")
	public void testSeries1() {
		CalcService ser = new CalcService();
		double expected = 5.0;
		assumeTrue(ser !=  null);
		double actual = ser.calcSeries(5, 3, 2);
		assertEquals(expected, actual);
	
	}
	
	@Tag("dev")
	@Test
	public void testSeries2() {
		CalcService ser = new CalcService();
		assumingThat(ser != null, ()->assertEquals(6.5, ser.calcSeries(5,5,3)));
		
	
	}
	
	@Tag("prod")
	@Test
	public void testSeries3() {
		CalcService ser = new CalcService();
		double expected = -6.5;
		double actual = ser.calcSeries(-5, -5, -3);
		assertEquals(expected, actual);
	
	}
}








