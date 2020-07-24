package Hard;

import Basic.LinkedList;
import Basic.Node;

public class LinkedListPallindrome2 {

  static Node<String> fastPtr, slowPtr, secondHalf;

  public static void main(String[] args) {
    LinkedList<String> ll1 = new LinkedList<String>();
    ll1.addNodes("A");
    ll1.addNodes("B");
    ll1.addNodes("C");
    ll1.addNodes("C");
    ll1.addNodes("B");
    ll1.addNodes("A");
    System.out.println("Pallindrome ? " + isPallindrome(ll1.getHead()));
    LinkedList<String> ll2 = new LinkedList<String>();
    ll2.addNodes("R");
    ll2.addNodes("A");
    ll2.addNodes("D");
    ll2.addNodes("A");
    ll2.addNodes("R");
    System.out.println("Pallindrome ? " + isPallindrome(ll2.getHead()));
    LinkedList<String> ll3 = new LinkedList<String>();
    ll3.addNodes("A");
    ll3.addNodes("B");
    ll3.addNodes("C");
    ll3.addNodes("D");
    ll3.addNodes("B");
    ll3.addNodes("A");
    System.out.println("Pallindrome ? " + isPallindrome(ll3.getHead()));
  }

  private static Boolean isPallindrome(Node<String> head) {
    fastPtr = head;
    slowPtr = head;
    Node<String> prevPtr = head;
    Node<String> midNode = null;

    // Finding Middle Element
    while (fastPtr != null && fastPtr.getNext() != null) {
      fastPtr = fastPtr.getNext().getNext();
      prevPtr = slowPtr;
      slowPtr = slowPtr.getNext();
    }

    // Initializing MidNode - for odd length list
    if (fastPtr != null) {
      midNode = slowPtr;
      slowPtr = slowPtr.getNext();
    }

    // Separate two list
    secondHalf = slowPtr;
    prevPtr.setNext(null);

    // Reverse Second Half of List
    reverse();

    // Compare two List
    Boolean isPallindrome = compare(head, secondHalf);

    // Reverse Second Half Again
    reverse();

    // Join first and second half of list
    if (midNode != null) {
      prevPtr.setNext(midNode);
      midNode.setNext(secondHalf);
    } else {
      prevPtr.setNext(secondHalf);
    }

    return isPallindrome;

  }

  private static void reverse() {
    Node<String> prev = null;
    Node<String> current = secondHalf;
    Node<String> nextNode = null;
    while (current != null) {
      nextNode = current.getNext();
      current.setNext(prev);
      prev = current;
      current = nextNode;
    }
    secondHalf = prev;
  }

  private static Boolean compare(Node<String> firstList, Node<String> secondList) {
    Boolean equalityFlag = false;
    while (firstList != null && secondList != null) {
      if (firstList.getData().equals(secondList.getData())) {
        equalityFlag = true;
      }
      firstList = firstList.getNext();
      secondList = secondList.getNext();
      if (firstList != null || secondList != null) {
        equalityFlag = false;
      }
    }
    return equalityFlag;
  }
}
