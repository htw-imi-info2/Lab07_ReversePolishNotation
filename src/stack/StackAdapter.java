package stack;

import java.util.Stack;

public class StackAdapter<E> {

	Stack<E> stack1;
	stack.Stack<E> stack2;
	boolean standard;

	public StackAdapter(boolean standard) {
		this.standard = standard;
		if (standard) {
			stack1 = new Stack<E>();
		} else {
			stack2 = new LinkedListStack<E>();
		}
	}

	public boolean isEmpty() {
		if (standard) {
			return stack1.isEmpty();
		} else {
			return stack2.isEmpty();
		}
	}

	public E top() throws Underflow {
		if (standard) {
			return stack1.peek();
		} else {
			return stack2.top();
		}
	}

	public void push(E element) {
		if (standard) {
			stack1.push(element);
		} else {
			stack2.push(element);
		}
	}

	public E pop() throws Underflow {
		if (standard) {
			return stack1.pop();
		} else {
			return stack2.pop();
		}
	}

}
