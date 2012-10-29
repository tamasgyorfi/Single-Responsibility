package hu.tamasgyorfi.kata.equations;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EquationsCalculator {

	public boolean isCorrect(String equation) {
		List<String> equationParts = getEquationParts(equation);
		
		int sum = Integer.valueOf(equationParts.get(0));
		
		for (int i=1;i<equationParts.size()-1;i+=2) {
			Integer nextValue = Integer.valueOf(equationParts.get(i+1));
			if (equationParts.get(i).equals("-")) {
				sum -= nextValue;
			} else {
				sum += nextValue;
			}
		}
		return sum == 100;
	}

	private List<String> getEquationParts(String equation) {
		List<String> parts = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(equation,"+-", true);
		while (tokenizer.hasMoreTokens()) {
			parts.add(tokenizer.nextToken());
		}
		return parts;
	}

}
