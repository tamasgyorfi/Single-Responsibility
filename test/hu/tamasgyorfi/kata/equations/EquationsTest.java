package hu.tamasgyorfi.kata.equations;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hu.tamasgyorfi.kata.equations.EquationsValidator;

import org.junit.Test;

public class EquationsTest {

	private EquationsValidator equations = new EquationsValidator();
	
	@Test
	public void isSyntacticallyCorect_returnsTrue_forCorrectSyntax() {
		assertTrue(equations.isSyntacticallyCorrect("123-45-67+89"));
	}
	
	@Test
	public void isSyntacticallyCorect_returnsFalse_forTooFewMinuses() {
		assertFalse(equations.isSyntacticallyCorrect("12345-67+89"));
	}

	@Test
	public void isSyntacticallyCorect_returnsFalse_forTooManyMinuses() {
		assertFalse(equations.isSyntacticallyCorrect("12-345-67-89"));
	}

	@Test
	public void isSyntacticallyCorect_returnsFalse_forTooManyPluses() {
		assertFalse(equations.isSyntacticallyCorrect("12345-6+7+89"));
	}

	@Test
	public void isSyntacticallyCorect_returnsFalse_forOneNumberMissing() {
		assertFalse(equations.isSyntacticallyCorrect("1345-6+7-89"));
	}

	@Test
	public void isSyntacticallyCorect_returnsFalse_forNumbersNotIncreasing() {
		assertFalse(equations.isSyntacticallyCorrect("12345-6+7-98"));
	}

	@Test
	public void isSyntacticallyCorect_returnsFalse_forContainingZero() {
		assertFalse(equations.isSyntacticallyCorrect("02345-6+7-98"));
	}

}
