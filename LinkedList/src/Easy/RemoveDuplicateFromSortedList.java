package Easy;

import Basic.LinkedList;
import Basic.Node;

public class RemoveDuplicateFromSortedList {

  static LinkedList<Integer> ll1 = new LinkedList<Integer>();

  public static void main(String[] args) {
    ll1.addNodes(20);
    ll1.addNodes(13);
    ll1.addNodes(13);
    ll1.addNodes(11);
    ll1.addNodes(11);
    ll1.addNodes(11);
    System.out.println("List before removal of duplicates");
    ll1.printNodes();

    removeDuplicates();

    System.out.println("List after removal of elements");
    ll1.printNodes();
  }

  public static void removeDuplicates() {
    Node<Integer> startNode = ll1.getHead();
    while (startNode != null && startNode.getNext() != null) {
      if (startNode.getData().equals(startNode.getNext().getData())) {
        startNode.setNext(startNode.getNext().getNext());
      } else {
        startNode.setNext(startNode.getNext());
      }
    }
  }

}
