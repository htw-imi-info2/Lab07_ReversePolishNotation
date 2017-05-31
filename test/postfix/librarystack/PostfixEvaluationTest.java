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
public class PostfixEvaluationTest {
	String comment, infix, postfix;
	double result;
	Postfix postfixEvaluatorLibraryStack, postfixEvaluatorOwnStack;

	public PostfixEvaluationTest(String comment, String infix, String postfix,
			double result) {
		this.comment = comment;
		this.infix = infix;
		this.postfix = postfix;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Collection<Object[]> data = TestCases.generalTestCases();
		//data.addAll(TestCases.exponentialTestCases());
		//data.addAll(TestCases.multiDigitTestCases());
		return data;
	}

	@Before
	public void createPostfix() {
		postfixEvaluatorLibraryStack = new Postfix(true);
		postfixEvaluatorOwnStack = new Postfix(false);
	}

	@Test
	public void testEvaluatePostfixLibrary() throws Underflow {
		assertEquals(comment + " (postfix was: " + postfix+")", result,
				postfixEvaluatorLibraryStack.evaluate(postfix), 0.0);
	}
	@Test
	public void testEvaluatePostfixOwn() throws Underflow {
		assertEquals(comment + " (postfix was: " + postfix+")", result,
				postfixEvaluatorOwnStack.evaluate(postfix), 0.0);
	}

}
