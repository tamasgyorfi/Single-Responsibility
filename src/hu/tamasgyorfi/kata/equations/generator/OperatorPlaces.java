package hu.tamasgyorfi.kata.equations.generator;

public class OperatorPlaces {
	private static final int EQUATION_LENGTH = 11;
	private int plusOperator = 1;
	private int firstMinusOperator = 1;
	private int secondMinusOperator = 1;

	private boolean done = false;

	public void moveOperatorsPlace() {
		if (plusOperator < EQUATION_LENGTH-1) {
			plusOperator++;
		} else if (firstMinusOperator < EQUATION_LENGTH -2) {
			plusOperator = 1;
			firstMinusOperator++;
		} else if (secondMinusOperator < EQUATION_LENGTH -3) {
			plusOperator = 1;
			firstMinusOperator = 1;
			secondMinusOperator++;
		}
		else {
			done = true;
		}
	}
	public boolean isDone() {
		return done;
	}

	public int getPlusOperatorPlace() {
		return plusOperator;
	}

	public int getFirstMinusOperatorPlace() {
		return firstMinusOperator;
	}

	
	
	public int getSecondMinusOperatorPlace() {
		return secondMinusOperator;
	}
	public void setPlusOperator(int plusOperator) {
		this.plusOperator = plusOperator;
	}
	public void setFirstMinusOperator(int firstMinusOperator) {
		this.firstMinusOperator = firstMinusOperator;
	}
	public void setSecondMinusOperator(int secondMinusOperator) {
		this.secondMinusOperator = secondMinusOperator;
	}
}
