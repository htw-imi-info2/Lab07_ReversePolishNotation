package stack;

public class LinkedListStack<E> implements Stack<E> {
	class Node<F>{
		F data;
		Node<F> next;
		public Node(F data){this.data = data;}
	}
	Node<E> top;
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public E top() throws Underflow {
		if (isEmpty()) throw new Underflow();
		return top.data;
	}

	@Override
	public void push(E element) {
		Node<E> node = new Node(element);
		node.next = top;
		top = node;
	}

	@Override
	public void pop() throws Underflow {
		if (isEmpty()) throw new Underflow();
		top = top.next;	
	}
	@Override
	public String toString(){
		if (isEmpty()) return "";
		String result = top.data.toString();
		for(Node<E> c = top.next; c != null; c = c.next)	
			result += ", " + c.data.toString();
		return result;
	}
}
