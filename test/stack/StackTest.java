package stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	Stack<String> stack;

	@Before
	public void createStack() {
		stack = new LinkedListStack<>();
	}

	/**
	 * simple tests
	 */
	@Test
	public void testPush1() {
		stack.push("a");
		assertEquals("a", stack.toString());
	}

	@Test
	public void testPush2() {
		stack.push("a");
		stack.push("b");
		assertEquals("b, a", stack.toString());
	}

	@Test
	public void testPop() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.pop();
		assertEquals("a", stack.toString());
	}

	@Test
	public void testPop2() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.pop();
		assertEquals("b, a", stack.toString());
	}

	/**
	 * Axiom 1: isEmpty(new Stack()) = true
	 */
	@Test
	public void axiom1() {
		assertEquals(true, stack.isEmpty());
	}

	/**
	 * Axiom 2: isEmpty(push(q,x)) = false
	 */
	@Test
	public void axiom2() {
		stack.push("A");
		assertEquals(false, stack.isEmpty());
	}

	/**
	 * Axiom 3: pop(new Stack()) = error
	 * 
	 * @throws Underflow
	 */
	@Test(expected = Underflow.class)
	public void axiom3() throws Underflow {
		stack.pop();
	}

	/**
	 * Axiom 4: getFront(new Stack()) = error
	 */
	@Test(expected = Underflow.class)
	public void axiom4() throws Underflow {
		stack.top();
	}

	/**
	 * Axiom 5: pop(push(s,x)) = x
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom5OnEmptyStack() throws Underflow {
		String before = stack.toString();
		stack.push("huhu");
		stack.pop();
		assertEquals(before, stack.toString());
	}

	@Test
	public void axiom5OnEmptyNonEmpty() throws Underflow {
		stack.push("a");
		stack.push("b");
		String before = stack.toString();
		stack.push("huhu");
		stack.pop();
		assertEquals(before, stack.toString());
	}

	/**
	 * Axiom 6: top(push(s,x)) = x
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom6OnEmptyStack() throws Underflow {
		String x = "huhu";
		stack.push(x);
		assertEquals(x, stack.top());
	}

	@Test
	public void axiom6() throws Underflow {
		stack.push("a");
		stack.push("b");

		String x = "huhu";
		stack.push(x);
		assertEquals(x, stack.top());
	}

	@Test
	public void stepByStep1() throws Underflow {
		stack.push("a");
		assertEquals("a", stack.top());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void stepByStep2() throws Underflow {
		stack.push("a");
		stack.push("b");
		assertEquals("b", stack.top());
		stack.pop();
		assertEquals("a", stack.top());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void stepByStep3() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		assertEquals("c", stack.top());
		stack.pop();
		assertEquals("b", stack.top());
		stack.pop();
		assertEquals("a", stack.top());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void stepByStep4() throws Underflow {
		stack.push("a");
		stack.push("b");
		assertEquals("b", stack.top());
		stack.pop();
		stack.push("c");
		assertEquals("c", stack.top());
		stack.pop();
		stack.push("d");
		assertEquals("d", stack.top());
		stack.pop();
		assertEquals("a", stack.top());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void stepByStep5() throws Underflow {
		stack.push("b");
		assertEquals("b", stack.top());
		stack.pop();
		stack.push("c");
		assertEquals("c", stack.top());
		stack.pop();
		stack.push("d");
		assertEquals("d", stack.top());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	@Test 
	public void popValue() throws Underflow {
		stack.push("a");
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
	@Test 
	public void popValue2() throws Underflow {
		stack.push("a");
		stack.push("b");
		assertEquals("b",stack.pop());
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test 
	public void popValue3() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		assertEquals("c",stack.pop());
		assertEquals("b",stack.pop());
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Characterization Test that shows bug in Stack implementation
	 * @throws Underflow
	 */
	@Test 
	public void popValueX() throws Underflow {
		stack.push("a");
		stack.push("b");
		assertEquals("a",stack.pop());
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
	/**
	 * Characterization Test that shows bug in Stack implementation
	 * @throws Underflow
	 */
	@Test 
	public void popValueXX() throws Underflow {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		assertEquals("b",stack.pop());
		assertEquals("a",stack.pop());
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
}
