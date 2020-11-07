package Medium;

/*
 * Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in
 * doubly linked list whose sum is equal to given value x
 * 
 * Example: Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9 x = 7 Output: (6, 1), (5,2)
 */
public class PairsWithGivenSumInDLL {

  public static void main(String[] args) {
    Node head = null;
    head = insert(head, 9);
    head = insert(head, 8);
    head = insert(head, 6);
    head = insert(head, 5);
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);
    int x = 7;
    print(head);
    pairSum(head, x);
  }

  static class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public static void print(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  public static Node insert(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    if (null != head) {
      head.prev = newNode;
    }
    return newNode;
  }

  private static void pairSum(Node head, int sum) {
    Node firstNode = head;
    Node lastNode = head;

    // Initializing the last Node
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }

    boolean found = false;

    while (firstNode != null && lastNode != null && firstNode != lastNode
        && lastNode.next != firstNode) {
      if (firstNode.data + lastNode.data == sum) {
        found = true;
        System.out.println("(" + firstNode.data + ", " + lastNode.data + ")");
        firstNode = firstNode.next;
        lastNode = lastNode.next;
      } else {
        if (firstNode.data + lastNode.data < sum) {
          firstNode = firstNode.next;
        } else {
          lastNode = lastNode.prev;
        }
      }
    }
    if (!found) {
      System.out.println("No Pair Found");
    }
  }
}


