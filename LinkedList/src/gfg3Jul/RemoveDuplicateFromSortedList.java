package gfg3Jul;

public class RemoveDuplicateFromSortedList {

	static LinkedList<Integer> ll1 = new LinkedList<Integer>();

	public static void main(String[] args) {
		ll1.addNodes(20);
		ll1.addNodes(13);
		ll1.addNodes(13);
		ll1.addNodes(11);
		ll1.addNodes(11);
		ll1.addNodes(11);
		System.out.println("List before removal of duplicates");
		ll1.printList();

		removeDuplicates();

		System.out.println("List after removal of elements");
		ll1.printList();
	}

	public static void removeDuplicates() {
		Node<Integer> startNode = ll1.getHead();
		while (startNode != null && startNode.next != null) {
			if (startNode.data.equals(startNode.next.data)) {
				startNode.next = startNode.next.next;
			} else {
				startNode = startNode.next;
			}
		}
	}

}
