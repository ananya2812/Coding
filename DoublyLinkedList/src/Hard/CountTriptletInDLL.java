package Hard;

import java.util.HashMap;
import java.util.Map;

/*
 * Count triplets in a sorted doubly linked list whose sum is equal to a given value x
 * 
 * Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value
 * x. Count triplets in the list that sum up to a given value x.
 */
class CountTriptletInDLL {

  public static void main(String args[]) {
    Node head = null;

    head = insert(head, 9);
    head = insert(head, 8);
    head = insert(head, 6);
    head = insert(head, 5);
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);

    int x = 17;
    System.out.println("count = " + countTripletsOptimized(head, x));
  }

  private static Node insert(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    if (null != head) {
      head.prev = newNode;
    }
    return newNode;
  }

  private static int countTriplets(Node head, int sum) {
    int count = 0;
    Map<Integer, Node> nodeMap = new HashMap<>();

    Node currNode = head;
    while (currNode != null) {
      nodeMap.put(currNode.data, currNode);
      currNode = currNode.next;
    }

    Node ptr1, ptr2;

    for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) {
      for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {

        Integer key = sum - ptr1.data - ptr2.data;
        if (nodeMap.containsKey(key) && nodeMap.get(key) != ptr1 && nodeMap.get(key) != ptr2) {
          count++;
        }
      }
    }
    return (count / 3);
  }

  private static int countTripletsOptimized(Node head, int sum) {
    int count = 0;

    Node currentNode, firstNode, lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }

    for (currentNode = head; currentNode != null; currentNode = currentNode.next) {
      firstNode = currentNode.next;
      int remainingSum = sum - currentNode.data;
      if (pairSum(firstNode, lastNode, remainingSum)) {
        count++;
      }
    }

    return count;
  }

  private static boolean pairSum(Node firstNode, Node lastNode, int sum) {
    boolean found = false;

    while (firstNode != null && lastNode != null && firstNode != lastNode
        && lastNode.next != firstNode) {
      if (firstNode.data + lastNode.data == sum) {
        found = true;
        firstNode = firstNode.next;
        lastNode = lastNode.prev;
      } else {
        if (firstNode.data + lastNode.data < sum) {
          firstNode = firstNode.next;
        } else {
          lastNode = lastNode.prev;
        }
      }
    }
    return found;
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
}


