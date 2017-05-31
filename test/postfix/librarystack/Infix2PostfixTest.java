package postfix.librarystack;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import postfix.Postfix;
import postfix.TestCases;
import stack.Underflow;

@RunWith(Parameterized.class)
public class Infix2PostfixTest {
	String comment, infix, postfix;
	double result;
	Postfix converterLibraryStack, converterOwnStack;

	public Infix2PostfixTest(String comment, String infix, String postfix, double result) {
		this.comment = comment;
		this.infix = infix;
		this.postfix = postfix;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Collection<Object[]> data = TestCases.generalTestCases();
		// data.addAll(TestCases.exponentialTestCases());
		// data.addAll(TestCases.multiDigitTestCases());
		return data;
	}

	@Before
	public void createConverter() {
		converterLibraryStack = new Postfix(true);
		converterOwnStack = new Postfix(false);
	}

	@Test
	public void testInfixToPostfixLibrary() throws Underflow {
		assertEquals(comment + " (infix was: " + infix + ")", postfix, converterLibraryStack.infixToPostfix(infix));
	}

	@Test
	public void testInfixToPostfixOwn() throws Underflow {
		assertEquals(comment + " (infix was: " + infix + ")", postfix, converterOwnStack.infixToPostfix(infix));
	}

}
