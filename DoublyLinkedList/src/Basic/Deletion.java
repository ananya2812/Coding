package Basic;

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
    dll.printList(dll.head);

    // Deleting first node
    dll.deleteNode(dll.head);

    System.out.println("\nList after deleting first node: ");
    dll.printList(dll.head);

    // Deleting middle node from 8->4->2
    dll.deleteNode(dll.head.next);

    System.out.println("\nList after Deleting middle node: ");
    dll.printList(dll.head);
  }
}
