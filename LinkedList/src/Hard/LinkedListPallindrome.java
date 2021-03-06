package Hard;

import java.util.Stack;
import Basic.LinkedList;
import Basic.Node;

/*
 * Given a singly linked list of characters, write a function that returns true if the given list is
 * a palindrome, else false.
 */
public class LinkedListPallindrome {

  public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList<String>();
    ll.addNodes("A");
    ll.addNodes("B");
    ll.addNodes("C");
    ll.addNodes("C");
    ll.addNodes("B");
    ll.addNodes("A");
    System.out.println("Pallindrome ? " + isPallindrome(ll.getHead()));
  }

  private static Boolean isPallindrome(Node<String> node) {
    Boolean isPallindrome = false;
    Node<String> temp = node;
    Stack<String> stack = new Stack<String>();
    while (temp != null) {
      stack.push(temp.getData());
      temp = temp.getNext();
    }

    while (node != null) {
      if (stack.pop().equals(node.getData())) {
        isPallindrome = true;
      } else {
        isPallindrome = false;
        break;
      }
      node = node.getNext();
    }
    return isPallindrome;
  }
}
