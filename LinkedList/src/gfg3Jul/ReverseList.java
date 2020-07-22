package gfg3Jul;

public class ReverseList {

	static LinkedList<Integer> list = new LinkedList<Integer>();

	public static void main(String[] args) {
		list.head = new Node<Integer>(85);
		list.head.next = new Node<Integer>(15);
		list.head.next.next = new Node<Integer>(4);
		list.head.next.next.next = new Node<Integer>(20);

		System.out.println("Given Linked list");
		list.printList();
		reverse();
		System.out.println("Reversed linked list ");
		list.printList();
	}

	private static void reverse() {
		Node<Integer> current = list.head;
		Node<Integer> prev = null;
		while (current != null) {
			Node<Integer> newNode = current.next;
			current.next = prev;
			prev = current;
			current = newNode;
		}
		list.head = prev;
	}
}
