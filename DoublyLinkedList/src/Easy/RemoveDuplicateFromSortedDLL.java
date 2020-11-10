package Easy;

/*
 * Given a sorted doubly linked list containing n nodes. The problem is to remove duplicate nodes
 * from the given list.
 */
public class RemoveDuplicateFromSortedDLL {

  public static void main(String args[]) {
    Node head = null;
    head = push(head, 12);
    head = push(head, 12);
    head = push(head, 10);
    head = push(head, 8);
    head = push(head, 8);
    head = push(head, 6);
    head = push(head, 4);
    head = push(head, 4);
    head = push(head, 4);
    head = push(head, 4);

    System.out.println("Original Doubly LinkedList");
    printList(head);

    /* remove duplicate nodes */
    removeDuplicates(head);
    System.out.println("\nDoubly linked list after removing duplicates:");
    printList(head);
  }

  public static void removeDuplicates(Node head) {
    if (head == null || head.next == null) {
      return;
    }
    Node currNode = head.next;
    while (currNode != null) {
      if (currNode.data == currNode.prev.data) {
        currNode.prev.next = currNode.next;
        if (null != currNode.next) {
          currNode.next.prev = currNode.prev;
        }
      }
      currNode = currNode.next;
    }
  }

  public static Node push(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
    return head;
  }

  public static void printList(Node head) {
    if (head == null) {
      System.out.println("Doubly Linked list empty");
    }
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
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
