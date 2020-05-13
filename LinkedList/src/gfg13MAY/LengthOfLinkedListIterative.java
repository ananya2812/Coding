package gfg13MAY;

import gfg13MAY.Node;

/*
 * Find Length of a Linked List (Iterative) Write a function to count the number of nodes in a given
 * singly linked list.
 * 
 * For example, the function should return 5 for linked list 1->3->1->2->1.
 */
public class LengthOfLinkedListIterative {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addNodes(1);
    ll.addNodes(3);
    ll.addNodes(0);
    ll.addNodes(0);
    System.out.println(getLength(ll.getHead()));
  }

  public static int getLength(Node<Integer> head) {
    Node<Integer> temp = head;
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.getNext();
    }
    return count;
  }
}
