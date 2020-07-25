package Easy;

/*
 * Split a Circular Linked List into two halves If there are odd number of nodes, then first list
 * should contain one extra.
 */
public class SplitInTwoHalves {

  static Node head, head1, head2;

  public static void main(String[] args) {
    head = new Node(12, null);
    head.next = new Node(56, null);
    head.next.next = new Node(2, null);
    head.next.next.next = new Node(11, null);
    head.next.next.next.next = new Node(13, null);
    head.next.next.next.next.next = head;

    System.out.println("Original Circular Linked list ");
    printList(head);
    System.out.println("");
    splitList();
    System.out.println("First Circular List ");
    printList(head1);
    System.out.println("");
    System.out.println("Second Circular List ");
    printList(head2);
  }

  static class Node {
    int data;
    Node next;

    Node() {}

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private static void printList(Node node) {
    Node temp = node;
    if (node != null) {
      do {
        System.out.print(temp.data + " ");
        temp = temp.next;
      } while (temp != node);
    }
  }

  private static void splitList() {
    if (head == null) {
      return;
    }
    Node fastPtr = head, slowPtr = head;
    while (fastPtr.next != head && fastPtr.next.next != head) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
    }
    // Case for even Nodes
    if (fastPtr.next.next == head) {
      fastPtr = fastPtr.next;
    }

    // Make Heads of 2 lists
    head1 = head;
    if (head.next != head) {
      head2 = slowPtr.next;
    }

    // Make 2nd half circular
    fastPtr.next = slowPtr.next;

    // Make 1st half circular
    slowPtr.next = head;
  }

}
