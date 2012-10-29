package hu.tamasgyorfi.kata.equations.generator;

import static org.junit.Assert.*;
import hu.tamasgyorfi.kata.equations.generator.OperatorPlaces;

import org.junit.Test;

public class OperatorPlacesTest {

	private OperatorPlaces operatorPlaces = new OperatorPlaces();

	@Test
	public void moveOperatorsPlace_shouldMovePlusOperator_whenNotAtTheEnd() {
		operatorPlaces.moveOperatorsPlace();
		
		assertOperatorPlaces(2, 1, 1);
		assertFalse(operatorPlaces.isDone());
	}


	@Test
	public void moveOperatorsPlace_shouldMoveFirstMinusOperator_whenPlusAtTheEnd() {
		setOperatorPlaces(10, 1, 1);
		operatorPlaces.moveOperatorsPlace();
		
		assertOperatorPlaces(1, 2, 1);
		assertFalse(operatorPlaces.isDone());
	}

	@Test
	public void moveOperatorsPlace_shouldMoveSecondMinusOperator_whenPlusAndFirstMinusAtTheEnd() {
		setOperatorPlaces(10, 9, 1);
		operatorPlaces.moveOperatorsPlace();
		
		assertOperatorPlaces(1, 1, 2);
		assertFalse(operatorPlaces.isDone());
	}

	@Test
	public void moveOperatorsPlace_shouldSetDoneFlag_whenNoMorePossibilities() {
		setOperatorPlaces(10, 9, 8);
		operatorPlaces.moveOperatorsPlace();
		
		assertOperatorPlaces(10, 9, 8);
		assertTrue(operatorPlaces.isDone());
	}

	private void setOperatorPlaces(int plusOperator, int firstMinus, int secondMinus) {
		operatorPlaces.setPlusOperator(plusOperator);
		operatorPlaces.setFirstMinusOperator(firstMinus);
		operatorPlaces.setSecondMinusOperator(secondMinus);
	}

	private void assertOperatorPlaces(int plusOperator, int firstMinusOperator, int secondMinusOperator) {
		assertEquals(plusOperator, operatorPlaces.getPlusOperatorPlace());
		assertEquals(firstMinusOperator, operatorPlaces.getFirstMinusOperatorPlace());
		assertEquals(secondMinusOperator, operatorPlaces.getSecondMinusOperatorPlace());
	}
}
