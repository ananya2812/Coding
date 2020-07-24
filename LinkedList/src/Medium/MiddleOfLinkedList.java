package Medium;

import Basic.LinkedList;
import Basic.Node;

/*
 * Find the middle of a given linked list 
 * Given a singly linked list, find middle of the linked
 * list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
 */
public class MiddleOfLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();
    ll.addNodes(20);
    ll.addNodes(4);
    ll.addNodes(15);
    ll.addNodes(35);
    ll.addNodes(135);
    middleOfList(ll.getHead());
  }

  private static void middleOfList(Node<Integer> head) {
    Node<Integer> slowPointer = head;
    Node<Integer> fastPointer = head;

    if (head == null) {
      System.out.println("Empty List");
      return;
    }
    while (fastPointer != null && fastPointer.getNext() != null) {
      fastPointer = fastPointer.getNext().getNext();
      slowPointer = slowPointer.getNext();
    }
    System.out.println(slowPointer.getData());
  }

}
