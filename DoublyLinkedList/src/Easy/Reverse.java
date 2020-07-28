package Easy;

import Basic.DoublyLinkedList;
import Basic.Node;

public class Reverse {

  public static void main(String[] args) {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

    /*
     * Let us create a sorted linked list to test the functions Created linked list will be
     * 10->8->4->2
     */
    list.push(2);
    list.push(4);
    list.push(8);
    list.push(10);

    System.out.println("Original linked list ");
    list.printList(list.getHead());

    Node<Integer> headNode = reverse(list.getHead());
    System.out.println("The reversed Linked List is ");
    list.printList(headNode);
  }

  private static Node<Integer> reverse(Node<Integer> headNode) {
    if (null == headNode || headNode.getNext() == null) {
      return headNode;
    }
    Node<Integer> currNode = headNode;
    Node<Integer> tempNode = null;

    while (currNode != null) {
      tempNode = currNode.getPrev();
      currNode.setPrev(currNode.getNext());
      currNode.setNext(tempNode);
      currNode = currNode.getPrev();
    }

    if (tempNode != null) {
      return tempNode.getPrev();
    }
    return headNode;
  }
}
