package demo.junit.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		int result = calc.add(10, 20);
		assertEquals(30, result, 0);
	}
	
	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		int result = calc.subtract(20, 10);
		assertEquals(10, result, 0);
	}
	
	@Test
	public void testMultiply() {
		Calculator calc = new Calculator();
		int result = calc.multiply(10, 10);
		assertEquals(100, result, 0);
	}
	
	@Test
	public void testdivide() {
		Calculator calc = new Calculator();
		int result = calc.divide(10, 10);
		assertEquals(1, result, 0);
	}
	

}
