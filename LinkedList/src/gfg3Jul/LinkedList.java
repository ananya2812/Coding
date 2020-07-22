package gfg3Jul;

public class LinkedList<T extends Comparable<T>> {

	Node<T> head;

	public LinkedList() {
		head = null;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void addNodes(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> currNode = head;
			while (currNode.next != null) {
				currNode = currNode.getNext();
			}
			currNode.next = newNode;
		}
	}

	public void printList() {
		if (head == null) {
			return;
		} else {
			Node<T> currNode = head;
			while (currNode != null) {
				System.out.println(currNode.getData());
				currNode = currNode.next;
			}
		}
	}

}
