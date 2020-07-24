package Easy;

import Basic.LinkedList;
import Basic.Node;

/*
 * Search an element in a Linked List (Recursive) Write a function that searches a given key ‘x’ in
 * a given singly linked list. The function should return true if x is present in linked list and
 * false otherwise.
 * 
 * For example, if the key to be searched is 15 and linked list is 14->21->11->30->10, then function
 * should return false. If key to be searched is 14, then the function should return true.
 */
public class SearchLinkedListRecursive {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addNodes(1);
    ll.addNodes(3);
    ll.addNodes(0);
    ll.addNodes(0);
    ll.addNodes(9);
    ll.addNodes(1);
    ll.addNodes(0);
    System.out.println(search(ll.getHead(), 111));
  }

  public static boolean search(Node<Integer> head, int x) {
    if (head == null) {
      return false;
    }

    if (head.getData() == x) {
      return true;
    }

    return search(head.getNext(), x);
  }
}
