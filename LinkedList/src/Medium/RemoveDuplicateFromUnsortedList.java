package Medium;

import java.util.HashSet;
import Basic.LinkedList;
import Basic.Node;

public class RemoveDuplicateFromUnsortedList {
  static LinkedList<Integer> ll1 = new LinkedList<Integer>();

  public static void main(String[] args) {
    ll1.addNodes(2);
    ll1.addNodes(13);
    ll1.addNodes(4);
    ll1.addNodes(13);
    ll1.addNodes(34);
    ll1.addNodes(10);
    System.out.println("List before removal of duplicates");
    ll1.printNodes();

    removeDuplicates();

    System.out.println("List after removal of elements");
    ll1.printNodes();
  }

  public static void removeDuplicates() {
    HashSet<Integer> nodeHash = new HashSet<>();
    Node<Integer> prevNode = null;
    Node<Integer> startNode = ll1.getHead();
    while (startNode != null) {
      if (nodeHash.contains(startNode.getData())) {
        prevNode.setNext(startNode.getNext());
      } else {
        nodeHash.add(startNode.getData());
        prevNode = startNode;
      }
      startNode = startNode.getNext();
    }
  }

}
