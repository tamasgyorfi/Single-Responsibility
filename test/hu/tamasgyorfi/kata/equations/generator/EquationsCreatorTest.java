package hu.tamasgyorfi.kata.equations.generator;

import hu.tamasgyorfi.kata.equations.EquationsCalculator;
import hu.tamasgyorfi.kata.equations.EquationsValidator;
import hu.tamasgyorfi.kata.equations.generator.EquationsCreator;
import hu.tamasgyorfi.kata.equations.generator.OperatorPlaces;

import java.io.PrintStream;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class EquationsCreatorTest {

	private JUnit4Mockery mockery = new JUnit4Mockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private EquationsCalculator calculator = mockery.mock(EquationsCalculator.class);
	private EquationsValidator validator = mockery.mock(EquationsValidator.class);
	private PrintStream out = mockery.mock(PrintStream.class);
	
	private EquationsCreator creator = new EquationsCreator(validator, calculator, out) {
		@Override
		protected void nextStep(OperatorPlaces operatorPlaces) {
			
		}
	};
	private OperatorPlaces operatorPlaces = new OperatorPlaces();
	
	@Test
	public void generateEquation_shouldSayEquationNotCorrect_forIncorrectEquation() {
		setOperatorPlaces(1, 5, 7);
		
		mockery.checking(new Expectations() {
			{
				oneOf(validator).isSyntacticallyCorrect("1+2345-6-789");
				will(returnValue(true));
				oneOf(out).print("Trying equation: 1+2345-6-789 = 100");
				oneOf(calculator).isCorrect("1+2345-6-789");
				will(returnValue(false));
				oneOf(out).println(" and it is NOT correct!");
			}
		});
		
		creator.generateEquation(operatorPlaces);
	}

	@Test
	public void generateEquation_shouldSayNothing_forSyntacticallyIncorrectEquation() {
		setOperatorPlaces(1, 5, 7);
		
		mockery.checking(new Expectations() {
			{
				oneOf(validator).isSyntacticallyCorrect("1+2345-6-789");
				will(returnValue(false));
			}
		});
		
		creator.generateEquation(operatorPlaces);
	}

	@Test
	public void generateEquation_shouldSayEquationCorrect_forCorrectEquation() {
		setOperatorPlaces(1, 5, 7);
		
		mockery.checking(new Expectations() {
			{
				oneOf(validator).isSyntacticallyCorrect("1+2345-6-789");
				will(returnValue(true));
				oneOf(out).print("Trying equation: 1+2345-6-789 = 100");
				oneOf(calculator).isCorrect("1+2345-6-789");
				will(returnValue(true));
				oneOf(out).println(" and it is correct!");
			}
		});
		
		creator.generateEquation(operatorPlaces);
	}

	private void setOperatorPlaces(int plusOperator, int firstMinus, int secondMinus) {
		operatorPlaces.setPlusOperator(plusOperator);
		operatorPlaces.setFirstMinusOperator(firstMinus);
		operatorPlaces.setSecondMinusOperator(secondMinus);
	}

}
