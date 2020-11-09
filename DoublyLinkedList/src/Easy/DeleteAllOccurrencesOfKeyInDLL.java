package Easy;

/*
 * Delete all occurrences of a given key in a doubly linked list.
 * 
 * Given a doubly linked list and a key x. The problem is to delete all occurrences of the given key
 * x from the doubly linked list.
 */
public class DeleteAllOccurrencesOfKeyInDLL {

  public static void main(String args[]) {
    Node head = null;

    /*
     * Create the doubly linked list: 2<->2<->10<->8<->4<->2<->5<->2
     */
    head = push(head, 2);
    head = push(head, 5);
    head = push(head, 2);
    head = push(head, 4);
    head = push(head, 8);
    head = push(head, 10);
    head = push(head, 2);
    head = push(head, 2);

    System.out.println("Original Doubly linked list: ");
    printList(head);

    int x = 10;

    // delete all occurrences of 'x'
    head = deleteAllOccurOfX(head, x);
    System.out.println("Doubly linked list after deletion of " + x + " :");
    printList(head);
  }

  private static Node push(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    if (null != head) {
      head.prev = newNode;
    }
    head = newNode;
    return head;
  }

  private static void printList(Node head) {
    Node currNode = head;
    while (currNode != null) {
      System.out.println(currNode.data);
      currNode = currNode.next;
    }
  }

  private static Node deleteAllOccurOfX(Node head, int x) {

    // if list is empty
    if (head == null) {
      return null;
    }

    Node currNode = head;

    while (currNode != null) {

      if (currNode.data == x) {
        if (currNode == head) {
          currNode = currNode.next;
          head = currNode;
          continue;
        }
        if (currNode.prev != null) {
          currNode.prev.next = currNode.next;
        }
        if (currNode.next != null) {
          currNode.next.prev = currNode.prev;
        }
      }
      currNode = currNode.next;
    }
    return head;
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
