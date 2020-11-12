package Medium;

/*
 * Given a doubly linked list, rotate the linked list counter-clockwise by N nodes. Here N is a
 * given positive integer and is smaller than the count of nodes in linked list.
 */
public class RotateDLLByNNodes {

  static Node head = null;

  public static void main(String[] args) {
    push('e');
    push('d');
    push('c');
    push('b');
    push('a');

    int N = 2;

    System.out.println("Given linked list ");
    printList(head);
    rotate(N);
    System.out.println();
    System.out.println("Rotated Linked list ");
    printList(head);
  }

  static void rotate(int N) {
    if (head == null || N <= 0) {
      return;
    }
    int pos = 1;
    Node currNode = head;
    while (null != currNode && pos < N) {
      pos++;
      currNode = currNode.next;
    }
    // pos greater than or equal to length of DLL
    if (null == currNode || currNode.next == null) {
      return;
    }

    Node newHead = currNode.next;
    newHead.prev = null;

    currNode.next = null;

    currNode = newHead;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    currNode.next = head;
    head.prev = currNode;
    head = newHead;
  }

  static void push(char data) {
    Node newNode = new Node(data);
    newNode.next = head;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
  }

  static void printList(Node head) {
    if (head == null) {
      System.out.print("Doubly Linked list empty");
    }
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  static class Node {
    char data;
    Node next, prev;

    Node(char data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }
}
