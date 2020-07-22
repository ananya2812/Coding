package gfg21Jul;

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
			Node<T> curr = head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(new Node<T>(data));
		}
	}

	public void printList() {
		if (head == null) {
			return;
		} else {
			Node<T> currNode = head;
			while (currNode != null) {
				System.out.println(currNode.getData());
				currNode = currNode.getNext();
			}
		}
	}
}
