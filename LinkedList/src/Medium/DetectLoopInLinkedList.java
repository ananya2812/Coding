package Medium;

import Basic.LinkedList;
import Basic.Node;

/*
 * Given a linked list, check if the linked list has loop or not Example : 1->2->3->4->5--->2
 */
public class DetectLoopInLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.addNodes(20);
    ll.addNodes(4);
    ll.addNodes(15);
    ll.addNodes(10);
    ll.getHead().getNext().getNext().getNext().setNext(ll.getHead());
    System.out.println("Loop Exists ? " + detectLoop(ll));
  }

  private static Boolean detectLoop(LinkedList<Integer> ll) {
    Node<Integer> slowPtr = ll.getHead();
    Node<Integer> fastPtr = ll.getHead();
    Boolean flag = false;
    while (fastPtr != null && fastPtr.getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
      if (fastPtr == slowPtr) {
        flag = true;
        break;
      }
    }
    return flag;
  }
}
