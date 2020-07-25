package Hard;

import Basic.LinkedList;
import Basic.Node;

/*
 * Segregate even and odd nodes in a Linked List Input: 17->15->8->12->10->5->4->1->7->6->NULL
 * Output: 8->12->10->4->6->17->15->5->1->7->NULL
 * 
 * Input: 8->12->10->5->4->1->6->NULL Output: 8->12->10->4->6->5->1->NULL
 * 
 * If all numbers are even then do not change the list Input: 8->12->10->NULL Output:
 * 8->12->10->NULL
 * 
 * If all numbers are odd then do not change the list Input: 1->3->5->7->NULL Output:
 * 1->3->5->7->NULL
 */
public class SegregateEvenOddNode {

  static LinkedList<Integer> ll;

  public static void main(String[] args) {
    ll = new LinkedList<Integer>();
    ll.addNodes(17);
    ll.addNodes(15);
    ll.addNodes(8);
    ll.addNodes(12);
    ll.addNodes(10);
    ll.addNodes(5);
    ll.addNodes(4);
    ll.addNodes(1);
    ll.addNodes(7);
    ll.addNodes(6);
    ll.printNodes();
    System.out.println("After Segregating");
    segregateEvenOdd();
    ll.printNodes();
  }

  private static void segregateEvenOdd() {
    Node<Integer> evenStart = null;
    Node<Integer> evenEnd = null;
    Node<Integer> oddStart = null;
    Node<Integer> oddEnd = null;
    Node<Integer> currNode = ll.getHead();
    while (currNode != null) {
      // Even Node Case
      if (currNode.getData() % 2 == 0) {
        // If no even node is encountered before
        if (null == evenStart) {
          evenStart = currNode;
          evenEnd = evenStart;
        } else {
          evenEnd.setNext(currNode);
          evenEnd = evenEnd.getNext();
        }
      } // Odd Node Case
      else {
        // If no odd node is encountered before
        if (null == oddStart) {
          oddStart = currNode;
          oddEnd = oddStart;
        } else {
          oddEnd.setNext(currNode);
          oddEnd = oddEnd.getNext();
        }
      }
      currNode = currNode.getNext();
    }

    // If the list contains only even or only odd node
    if (null == oddStart || null == evenStart) {
      return;
    }

    ll.setHead(evenStart);
    evenEnd.setNext(oddStart);
    oddEnd.setNext(null);
  }

}
