package hu.tamasgyorfi.kata.equations.main;

import hu.tamasgyorfi.kata.equations.EquationsCalculator;
import hu.tamasgyorfi.kata.equations.EquationsValidator;
import hu.tamasgyorfi.kata.equations.generator.EquationsCreator;
import hu.tamasgyorfi.kata.equations.generator.OperatorPlaces;

public class EquationsMain {

	public static void main(String[] args) {
		EquationsCreator generator = getEquationsCreator();
		OperatorPlaces operatorPlaces = new OperatorPlaces();

		generator.generateEquation(operatorPlaces);
	}

	private static EquationsCreator getEquationsCreator() {
		EquationsValidator validator = new EquationsValidator();
		EquationsCalculator calculator = new EquationsCalculator();
		return new EquationsCreator(validator, calculator, System.out);
	}

}
