package gfg3Jul;

import java.util.HashSet;

public class RemoveDuplicateFromUnsortedList {
	static LinkedList<Integer> ll1 = new LinkedList<Integer>();

	public static void main(String[] args) {
		ll1.addNodes(2);
		ll1.addNodes(13);
		ll1.addNodes(4);
		ll1.addNodes(13);
		ll1.addNodes(34);
		ll1.addNodes(10);
		System.out.println("List before removal of duplicates");
		ll1.printList();

		removeDuplicates();

		System.out.println("List after removal of elements");
		ll1.printList();
	}

	public static void removeDuplicates() {
		HashSet<Integer> nodeHash = new HashSet<>();
		Node<Integer> prevNode = null;
		Node<Integer> startNode = ll1.getHead();
		while (startNode != null) {
			if (nodeHash.contains(startNode.data)) {
				prevNode.next = startNode.next;
			} else {
				nodeHash.add(startNode.data);
				prevNode = startNode;
			}
			startNode = startNode.next;
		}
	}

}
