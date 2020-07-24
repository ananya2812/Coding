package Easy;

import Basic.LinkedList;
import Basic.Node;

/*
 * Given two lists sorted in increasing order, create and return a new list representing the
 * intersection of the two lists. The new list should be made with its own memory — the original
 * lists should not be changed.
 * 
 * Input: First linked list: 1->2->3->4->6 Second linked list be 2->4->6->8, Output: 2->4->6. The
 * elements 2, 4, 6 are common in both the list so they appear in the intersection list.
 */
public class IntersectionSortedLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> first = new LinkedList<>();
    first.addNodes(1);
    first.addNodes(2);
    first.addNodes(3);
    first.addNodes(4);
    first.addNodes(6);
    System.out.println("First List : ");
    first.printNodes();
    LinkedList<Integer> second = new LinkedList<>();
    second.addNodes(2);
    second.addNodes(4);
    second.addNodes(6);
    second.addNodes(8);
    System.out.println("Second List : ");
    second.printNodes();
    Node<Integer> intersectedListHead = findIntersection(first.getHead(), second.getHead());
    System.out.println("Intersected List : ");
    printList(intersectedListHead);
  }

  public static void printList(Node<Integer> node) {
    while (node != null) {
      System.out.println(node.getData());
      node = node.getNext();
    }
  }


  private static Node<Integer> findIntersection(Node<Integer> firstHead, Node<Integer> secHead) {
    LinkedList<Integer> dummyList = new LinkedList<>();
    while (firstHead != null && secHead != null) {
      if (firstHead.getData().equals(secHead.getData())) {
        dummyList.addNodes(firstHead.getData());
        firstHead = firstHead.getNext();
        secHead = secHead.getNext();
      } else if (firstHead.getData() < secHead.getData()) {
        firstHead = firstHead.getNext();
      } else {
        secHead = secHead.getNext();
      }
    }
    return dummyList.getHead();
  }
}
