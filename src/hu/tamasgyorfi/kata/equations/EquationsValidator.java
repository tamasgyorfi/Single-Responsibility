package hu.tamasgyorfi.kata.equations;

public class EquationsValidator {

	private static final String OPERATOR = "[-|+]";
	private static final String NUMBERS = "[1-9]+";

	public boolean isSyntacticallyCorrect(String equation) {
		return correctFormat(equation) && correctNumberOfOperators(equation)
				&& allNumbersContained(equation);
	}

	private boolean allNumbersContained(String equation) {
		return equation.replaceAll("-", "").replaceAll("\\+", "")
				.matches("123456789");
	}

	private boolean correctNumberOfOperators(String equation) {
		return containsTwoMinusOperators(equation)
				&& containsOnePlusOperator(equation);
	}

	private boolean containsOnePlusOperator(String equation) {
		return equation.replaceAll(NUMBERS, "").replaceAll("-", "")
				.matches("\\+");
	}

	private boolean containsTwoMinusOperators(String equation) {
		return equation.replaceAll(NUMBERS, "").replaceAll("\\+", "")
				.matches("--");
	}

	private boolean correctFormat(String equation) {
		return equation.matches(NUMBERS + OPERATOR + NUMBERS + OPERATOR
				+ NUMBERS + OPERATOR + NUMBERS);
	}
}
