package hu.tamasgyorfi.kata.equations.generator;

import hu.tamasgyorfi.kata.equations.EquationsCalculator;
import hu.tamasgyorfi.kata.equations.EquationsValidator;

import java.io.PrintStream;

public class EquationsCreator {

	private static final String NUMBER_SEQUENCE = "123456789";

	private EquationsValidator validator;
	private EquationsCalculator calculator;
	private PrintStream out;
	
	int count = 1;

	public EquationsCreator(EquationsValidator validator, EquationsCalculator calculator, PrintStream out) {
		this.validator = validator;
		this.calculator = calculator;
		this.out = out;
	}
	
	public void generateEquation(OperatorPlaces operatorPlaces) {
		StringBuilder builder = createSequence(operatorPlaces);

		if (validator.isSyntacticallyCorrect(builder.toString())) {
			out.print(count++ + " Trying equation: " + builder.toString() +" = 100");
			if (calculator.isCorrect(builder.toString())) {
				out.println(" and it is correct!");
			} else {
				out.println(" and it is NOT correct!");
			}
		} 
		nextStep(operatorPlaces);
	}

	protected void nextStep(OperatorPlaces operatorPlaces) {
		if (operatorPlaces.isDone()) {
			System.exit(0);
		}
		operatorPlaces.moveOperatorsPlace();
		generateEquation(operatorPlaces);
	}

	private StringBuilder createSequence(OperatorPlaces operatorPlaces) {
		StringBuilder sequence = new StringBuilder(NUMBER_SEQUENCE);

		return sequence.insert(operatorPlaces.getFirstMinusOperatorPlace(), '-')
				.insert(operatorPlaces.getSecondMinusOperatorPlace(), '-')
				.insert(operatorPlaces.getPlusOperatorPlace(), '+');
	}

}
