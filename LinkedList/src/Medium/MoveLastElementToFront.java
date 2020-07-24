package Medium;

import Basic.LinkedList;
import Basic.Node;

/*
 * Write a function that moves the last element to the front in a given Singly Linked List. For
 * example, if the given Linked List is 1->2->3->4->5, then the function should change the list to
 * 5->1->2->3->4.
 */
public class MoveLastElementToFront {

  static LinkedList<Integer> ll;

  public static void main(String[] args) {
    ll = new LinkedList<Integer>();
    ll.addNodes(1);
    ll.addNodes(2);
    ll.addNodes(3);
    ll.addNodes(4);
    ll.addNodes(5);
    ll.printNodes();
    System.out.println("After Movement");
    moveLastElementToFront();
  }

  private static void moveLastElementToFront() {
    if (ll.getHead() == null || ll.getHead().getNext() == null) {
      return;
    }

    Node<Integer> lastNode = ll.getHead();
    Node<Integer> prev_lastNode = null;

    while (lastNode.getNext() != null) {
      prev_lastNode = lastNode;
      lastNode = lastNode.getNext();
    }

    prev_lastNode.setNext(lastNode.getNext());
    lastNode.setNext(ll.getHead());
    ll.setHead(lastNode);
    ll.printNodes();
  }

}
