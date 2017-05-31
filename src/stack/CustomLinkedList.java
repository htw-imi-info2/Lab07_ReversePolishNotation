package stack;

import java.lang.StringBuilder;

/**
 * Created by Kain on 22-May-17.
 */
public class CustomLinkedList<E> {
	private Node<E> first;
	private Node<E> last;

	public CustomLinkedList() {
		first = null;
		last = null;
	}

	public void add(E element) {
		Node<E> node = new Node<>(element);

		if (first == null) {
			first = last = node;
		} else {
			last.setNext(node);
		}

		last = node;
	}

	public void addFirst(E element) {

		Node<E> node = new Node<>(element);
		node.setNext(first);
		first = node;
	}

	public E removeLast() throws Underflow {

		if (isEmpty()) {
			throw new Underflow();
		}
		if (first == last) {
			Node<E> lastElement = first;
			first = last = null;
			return lastElement.getData();
		}

		Node<E> current = first;

		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}

		E lastElement = current.getNext().getData();
		last = current;
		current.setNext(null);
		return lastElement;
	}

	public E getLast() throws Underflow {
		if (isEmpty()) {
			throw new Underflow();
		}
		return (E) last.getData();
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {

		if (isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder("");
		Node<E> current = first;
		while (current != null) {
			result.insert(0, current.getData().toString() + ", ");
			current = current.getNext();
		}

		return result.substring(0, result.length() - 2);
	}
}
