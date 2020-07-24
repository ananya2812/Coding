package Medium;

import Basic.LinkedList;
import Basic.Node;

public class ReverseList {

  static LinkedList<Integer> list = new LinkedList<Integer>();

  public static void main(String[] args) {
    list.setHead(new Node<Integer>(85));
    list.getHead().setNext(new Node<Integer>(15));
    list.getHead().getNext().setNext(new Node<Integer>(4));
    list.getHead().getNext().getNext().setNext(new Node<Integer>(20));

    System.out.println("Given Linked list");
    list.printNodes();
    reverse();
    System.out.println("Reversed linked list ");
    list.printNodes();
  }

  private static void reverse() {
    Node<Integer> current = list.getHead();
    Node<Integer> prev = null;
    while (current != null) {
      Node<Integer> newNode = current.getNext();
      current.setNext(prev);
      prev = current;
      current = newNode;
    }
    list.setHead(prev);
  }
}
