package gfg23May;

public class LinkedList<T extends Comparable<T>> {

	Node<T> head = null;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void addNodes(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> lastNode = head;
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(new Node<T>(data));
		}
	}
}
