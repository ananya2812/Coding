package Easy;

/*
 * Given a circular linked list, count number of nodes in it.
 */
public class CountNodes {

  public static void main(String[] args) {
    Node head = new Node(1, null);
    head.next = new Node(2, null);
    head.next.next = new Node(3, null);
    head.next.next.next = new Node(4, null);
    head.next.next.next.next = head;
    System.out.print(countNode(head));
  }

  private static int countNode(Node head) {
    if (head == null) {
      return 0;
    }
    Node temp = head.next;
    int count = 1;
    while (temp != head) {
      count++;
      temp = temp.next;
    }
    return count;
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
