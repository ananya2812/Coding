package Easy;

import Basic.LinkedList;
import Basic.Node;

/*
 * Write a GetNth() function that takes a linked list and an integer index and returns the data
 * value stored in the node at that index position.
 * 
 * Input: 1->10->30->14, index = 2 Output: 30 The node at index 2 is 30
 */
public class NthNodeLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addNodes(1);
    ll.addNodes(3);
    ll.addNodes(0);
    ll.addNodes(0);
    ll.addNodes(9);
    ll.addNodes(1);
    ll.addNodes(0);
    System.out.println(getNth(ll.getHead(), 20));
  }

  public static int getNth(Node<Integer> curr, int index) {
    int count = 0;
    Node<Integer> temp = curr;
    while (temp != null) {
      if (count == index) {
        return temp.getData();
      }
      temp = temp.getNext();
      count++;
    }
    assert (false);
    return 0;
  }

}
