package stack;

public class LinkedListStack<E> implements Stack<E> {

	private CustomLinkedList<E> list;

	public LinkedListStack()
	{
		list = new CustomLinkedList<E>();

	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E top() throws Underflow {
		return list.getLast();
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		list.add(element);
	}

	@Override
	public E pop() throws Underflow {
		return list.removeLast();
	}

	public String toString()
	{
		return list.toString();
	}

}
