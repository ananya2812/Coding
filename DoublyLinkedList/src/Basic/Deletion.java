package Basic;

/*
 * Delete a node in a Doubly Linked List
 */
public class Deletion {

  public static void main(String[] args) {
    // Start with the empty list
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

    // Insert 2. So linked list becomes 2->NULL
    dll.push(2);

    // Insert 4. So linked list becomes 4->2->NULL
    dll.push(4);

    // Insert 8. So linked list becomes 8->4->2->NULL
    dll.push(8);

    // Insert 10. So linked list becomes 10->8->4->2->NULL
    dll.push(10);

    System.out.println("Created DLL is: ");
    dll.printList(dll.getHead());

    // Deleting first node
    dll.deleteNode(dll.getHead());

    System.out.println("\nList after deleting first node: ");
    dll.printList(dll.getHead());

    // Deleting middle node from 8->4->2
    dll.deleteNode(dll.getHead().getNext());

    System.out.println("\nList after Deleting middle node: ");
    dll.printList(dll.getHead());
  }
}



