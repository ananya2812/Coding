package Hard;

/*
 * Write a function findFirstLoopNode() that checks whether a given Linked List contains a loop. If
 * the loop is present then it returns point to the first node of the loop. Else it returns NULL.
 * 
 */
public class FirstNodeOfLoopInLL {

  public static void main(String[] args) {
    Node head = newNode(50);
    head.next = newNode(20);
    head.next.next = newNode(15);
    head.next.next.next = newNode(4);
    head.next.next.next.next = newNode(10);

    // Create a loop for testing
    head.next.next.next.next.next = head.next.next;

    Node res = detectAndRemoveLoop(head);
    if (res == null)
      System.out.print("Loop does not exist");
    else
      System.out.print("Loop starting node is " + res.data);
  }

  static class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private static Node newNode(int data) {
    Node newNode = new Node(data);
    return newNode;
  }

  private static Node detectAndRemoveLoop(Node head) {
    if (head == null || head.next == null) {
      return null;
    }

    Node fastPtr = head, slowPtr = head;

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (slowPtr == fastPtr) {
        break;
      }
    }

    if (slowPtr != fastPtr) {
      return null;
    }

    slowPtr = head;
    while (slowPtr != fastPtr) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
    }
    return slowPtr;

  }

}


