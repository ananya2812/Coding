package Basic;

public class Insertion {

  public static void main(String[] args) {
    /* Start with the empty list */
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    // Insert 6. So linked list becomes 6->NULL
    dll.append(6);
    // Insert 7 at the beginning. So linked list becomes 7->6->NULL
    dll.push(7);
    // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
    dll.push(1);
    // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
    dll.append(4);
    // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
    dll.insertAfter(dll.getHead().getNext(), 8);
    dll.insertBefore(dll.getHead().getNext(), 5);
    System.out.println("Created DLL is: ");
    dll.printList(dll.getHead());
  }
}
