package gfg3Jul;

public class Node<T extends Comparable<T>> {

	T data;
	Node<T> next;

	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}
