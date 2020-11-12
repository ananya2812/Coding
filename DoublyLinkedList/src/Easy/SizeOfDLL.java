package Easy;

/*
 * Given a doubly linked list, the task is to find the size of that doubly linked list.
 */
public class SizeOfDLL {

  public static void main(String args[]) {
    Node head = null;
    head = push(head, 4);
    head = push(head, 3);
    head = push(head, 2);
    head = push(head, 1);
    System.out.println(findSize(head));
  }

  static int findSize(Node node) {
    int count = 0;
    while (node != null) {
      count++;
      node = node.next;
    }
    return count;
  }

  static Node push(Node head_ref, int data) {
    Node newNode = new Node(data);
    newNode.next = (head_ref);
    if ((head_ref) != null) {
      (head_ref).prev = newNode;
    }
    (head_ref) = newNode;
    return head_ref;
  }

  static class Node {
    int data;
    Node next, prev;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

}
