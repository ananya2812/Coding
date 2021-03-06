package Medium;

import Basic.LinkedList;
import Basic.Node;

/*
 * Write a function detectAndCountLoop() that checks whether a given Linked List contains loop and
 * if loop is present then returns count of nodes in loop
 */

public class LengthofLoopInLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.addNodes(20);
    ll.addNodes(4);
    ll.addNodes(15);
    ll.addNodes(10);
    ll.addNodes(120);
    ll.getHead().getNext().getNext().getNext().getNext().setNext(ll.getHead().getNext());
    System.out.println("Loop ? " + detectLoop(ll));
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
    if (flag) {
      countNode(slowPtr);
    }
    return flag;
  }

  private static void countNode(Node<Integer> node) {
    Node<Integer> temp = node;
    int count = 1;
    while (temp.getNext() != node) {
      count++;
      temp = temp.getNext();
    }
    System.out.println("Length of Node : " + count);
  }

}
