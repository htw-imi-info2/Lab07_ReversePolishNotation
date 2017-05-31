package postfix;

import stack.StackAdapter;
import stack.Underflow;

public class Postfix {
	
	private boolean standard;
	
	public Postfix(boolean standard){
		this.standard = standard;
	}

	public String infixToPostfix(String infix) throws Underflow {
		
		StackAdapter<Character> stack = new StackAdapter<>(standard);

		String outputString = "";
		for (char c : infix.toCharArray()) {
			if (isNumber(c)) {
				outputString += c + " ";
			}
			if (c == '(') {
				stack.push(c);
			}

			if (isOperator(c)) {
				if (stack.isEmpty()) {
					stack.push(c);
				} else {

					while (!stack.isEmpty()) {
						if (priority(stack.top()) >= priority(c)) {
							outputString += stack.top() + " ";
							stack.pop();
						} else {
							break;
						}
					}

					stack.push(c);
				}
			}

			if (c == ')') {
				while (!stack.isEmpty() && stack.top() != '(') {
					outputString += stack.top() + " ";
					stack.pop();
				}
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
			outputString += stack.top() + " ";
			stack.pop();
		}
		System.out.println(outputString);
		return outputString.substring(0, outputString.length() - 1);
	}

	public double evaluate(String postfix) throws Underflow {
	
		StackAdapter<Double> stack = new StackAdapter<>(standard);

		for (char c : postfix.toCharArray()) {
			if (isNumber(c)) {
				stack.push((double) (c - 48));
			}
			if (isOperator(c)) {
				double right, left, result = 0;
				right = stack.top();stack.pop();
				left = stack.top();stack.pop();

				if (c == '+') {
					result = left + right;
				}
				if (c == '-') {
					result = left - right;
				}
				if (c == '*') {
					result = left * right;
				}
				if (c == '/') {
					result = left / right;
				}
				if (c == '^') {
					result = left;
					if (right > 0) {
						result = power(left, right);
					}
					if (right < 0) {
						result = 1 / power(left, -right);
					}
					if (right == 0)
						result = 1;
				}
				stack.push(result);
			}

		}
		return stack.pop();
	}

	private double power(double a, double b) {
		double result = a;
		for (int i = 0; i < b - 1; i++) {
			result *= a;
		}
		return result;
	}

	private boolean isNumber(char c) {
		// returns the number if it's a number
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}

	private boolean isOperator(char c) {
		// int values for {+, -, *, /, ^} in that order
		char[] operators = { '+', '-', '*', '/', '^' };
		for (char i : operators) {
			if (c == i) {
				return true;
			}
		}
		return false;
	}

	private int priority(char c) {
		char[] operators = { '+', '-', '*', '/', '^' };
		int counter = 0;
		for (char op : operators) {
			if (c == op) {
				break;
			}
			counter++;
		}
		if (counter <= 1)
			return 0;
		if (counter <= 3)
			return 1;
		if (counter == 4)
			return 2;
		return -1;
	}
}
