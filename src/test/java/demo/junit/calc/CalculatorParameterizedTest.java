package demo.junit.calc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class CalculatorParameterizedTest {
	
	private int expected;
	private int valueOne;
	private int valueTwo;
	
	
	public CalculatorParameterizedTest(int expected, int valueOne, int valueTwo) {
		super();
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}
	
	@Parameters
	public static Collection<Integer[]> getParameters() {
		return Arrays.asList(new Integer[][]{
				{2, 1, 1},
				{3 ,2 ,1},
				{4 ,2 ,2}
		});
	}
	
	@Test
	//@Parameters(source=CalculatorParameterizedTest.class , method="getParameters")
	public void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.add(valueOne, valueTwo),0);
	}
	
	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.subtract(valueOne, valueTwo),0);
	}
	

}
