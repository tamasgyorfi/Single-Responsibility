package hu.tamasgyorfi.kata.equations;
import static org.junit.Assert.*;
import hu.tamasgyorfi.kata.equations.EquationsCalculator;

import org.junit.Test;


public class EquationsCalculatorTest {

	private EquationsCalculator calculator = new EquationsCalculator(); 
	
	@Test
	public void isEquationCorrect_returnsTrue_forCorrectEquation() {
		assertTrue(calculator.isCorrect("123-45-67+89"));
	}
	
	@Test
	public void isEquationCorrect_returnsFalse_forIncorrectEquation() {
		assertFalse(calculator.isCorrect("12-345-67+89"));
	}

}
