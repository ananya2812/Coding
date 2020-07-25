package Easy;

/*
 * Given a singly linked list, find if the linked list is circular or not.
 */
public class CheckIfCircular {

  public static void main(String[] args) {
    Node head = new Node(1, null);
    head.next = new Node(2, null);
    head.next.next = new Node(3, null);
    head.next.next.next = new Node(4, null);
    System.out.print(isCircular(head) ? "Yes\n" : "No\n");
    head.next.next.next.next = head;
    System.out.print(isCircular(head) ? "Yes\n" : "No\n");
  }

  private static Boolean isCircular(Node head) {
    if (head == null) {
      return true;
    }
    Node temp = head.next;
    while (temp != null && temp != head) {
      temp = temp.next;
    }
    return (temp == head);
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
}
