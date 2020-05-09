package Basic;

import java.util.ArrayList;
import java.util.List;

public class LinkedListImpl<T extends Comparable<T>> implements Cloneable {

  Node<T> head = null;

  /**
   * Insert the data into the correct position in a sorted list. Assume that the list is sorted in
   * ascending order.
   */
  public void insertSorted(T data) {
    if (countNodes() == 0 || head.getData().compareTo(data) > 0) {
      Node<T> currHead = head;
      head = new Node<T>(data);
      head.setNext(currHead);
    } else {
      Node<T> currNode = head;
      while (currNode.getNext() != null && currNode.getNext().getData().compareTo(data) < 0) {
        currNode = currNode.getNext();
      }
      Node<T> newNode = new Node<T>(data);
      newNode.setNext(currNode.getNext());
      currNode.setNext(newNode);
    }
  }

  private int countNodes() {
    if (head == null) {
      return 0;
    }
    Node<T> currentNode = head;
    int count = 0;
    while (currentNode != null) {
      count++;
      currentNode = currentNode.getNext();
    }
    return count;
  }

  /**
   * Split a linked list into 2 equal parts. If there are an odd number of elements, the extra
   * element should be in the first list.
   */
  public List<Node<T>> frontBackSplit() {
    List<Node<T>> result = new ArrayList<>();
    Node<T> front = null;
    Node<T> back = null;
    if (head == null) {
      front = null;
      back = null;
    } else if (head.getNext() == null) {
      front = head;
      back = null;
    } else {
      Node<T> slow = head;
      Node<T> fast = head;
      while (fast != null) {
        fast = fast.getNext();
        if (fast == null) {
          break;
        }
        fast = fast.getNext();
        if (fast != null) {
          slow = slow.getNext();
        }
      }
      front = head;
      back = slow.getNext();
      slow.setNext(null);

    }
    result.add(front);
    result.add(back);
    return result;
  }

}
