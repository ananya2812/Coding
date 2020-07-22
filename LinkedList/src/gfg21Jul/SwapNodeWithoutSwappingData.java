package gfg21Jul;

/*
 * Swap nodes in a linked list without swapping data Given a linked list and two keys in it, swap
 * nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes may
 * be expensive in many situations when data contains many fields. It may be assumed that all keys
 * in linked list are distinct.
 * 
 * Examples:
 * 
 * Input: 10->15->12->13->20->14, x = 12, y = 20 Output: 10->15->20->13->12->14
 * 
 * Input: 10->15->12->13->20->14, x = 10, y = 20 Output: 20->15->12->13->10->14
 * 
 * Input: 10->15->12->13->20->14, x = 12, y = 13 Output: 10->15->13->12->20->14
 */
public class SwapNodeWithoutSwappingData {

  static LinkedList<Integer> ll;

  public static void main(String[] args) {
    ll = new LinkedList<Integer>();
    ll.addNodes(10);
    ll.addNodes(15);
    ll.addNodes(12);
    ll.addNodes(13);
    ll.addNodes(20);
    ll.addNodes(14);
    ll.printList();
    System.out.println("After Swapping");
    swapNodes(12, 20);
  }

  public static void swapNodes(int x, int y) {
    if (x == y) {
      return;
    }

    Node<Integer> currX = ll.head, prevX = null;
    while (currX != null && currX.data != x) {
      prevX = currX;
      currX = currX.next;
    }

    Node<Integer> currY = ll.head, prevY = null;
    while (currX != null && currY.data != y) {
      prevY = currY;
      currY = currY.next;
    }

    if (currX == null || currY == null) {
      return;
    }

    if (prevX != null) {
      prevX.next = currY;
    } else {
      ll.setHead(currY);
    }

    if (prevY != null) {
      prevY.next = currX;
    } else {
      ll.setHead(currX);
    }

    Node<Integer> temp = currX.next;
    currX.next = currY.next;
    currY.next = temp;

    ll.printList();
  }
}
