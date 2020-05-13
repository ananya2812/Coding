package gfg13MAY;

/*
 * Find Length of a Linked List (Recursive) Write a function to count the number of nodes in a given
 * singly linked list.
 * 
 * For example, the function should return 5 for linked list 1->3->1->2->1.
 */
public class LengthOfLinkedListRecursive {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addNodes(1);
    ll.addNodes(3);
    ll.addNodes(0);
    ll.addNodes(0);
    ll.addNodes(9);
    ll.addNodes(1);
    ll.addNodes(0);
    System.out.println(getLength(ll.getHead()));
  }

  public static int getLength(Node<Integer> head) {
    if (head == null) {
      return 0;
    } else {
      return 1 + getLength(head.getNext());
    }
  }

}
