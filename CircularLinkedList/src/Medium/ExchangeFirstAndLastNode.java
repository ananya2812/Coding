package Medium;

/*
 * Given a Circular linked list exchange the first and the last node. The task should be done with
 * only one extra node, you can not declare more than one extra node and also you are not allowed to
 * declare any other temporary variable.
 * 
 * Input : 5 4 3 2 1 Output : 1 4 3 2 5
 * 
 * Input : 6 1 2 3 4 5 6 7 8 9 Output : 9 1 2 3 4 5 6 7 8 6
 */
public class ExchangeFirstAndLastNode {

  public static void main(String[] args) {
    int i;
    Node head = null;
    head = addToEmpty(head, 6);

    for (i = 5; i > 0; i--) {
      head = addBegin(head, i);
    }

    System.out.println("List Before: ");
    traverse(head);
    head = exchangeNodes(head);
    System.out.println("List After: ");
    traverse(head);
  }

  static class Node {
    int data;
    Node next;

    Node() {};

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private static Node addToEmpty(Node head, int data) {
    if (null == head) {
      Node temp = new Node(data, head);
      head = temp;
      head.next = head;
      return head;
    } else {
      return head;
    }
  }

  private static Node addBegin(Node head, int data) {
    if (null != head) {
      Node temp = new Node(data, head.next);
      head.next = temp;
      return head;
    } else {
      return addToEmpty(head, data);
    }
  }

  private static void traverse(Node head) {
    Node temp = head;
    do {
      System.out.println(temp.data);
      temp = temp.next;
    } while (temp != head);
  }

  private static Node exchangeNodes(Node head) {
    // Get previous of last node
    Node previous = head;

    while (previous.next.next != head) {
      previous = previous.next;
    }

    previous.next.next = head.next;
    head.next = previous.next;
    previous.next = head;
    head = head.next;
    return head;
  }
}
