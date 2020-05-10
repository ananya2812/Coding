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

  /**
   * Remove duplicates in a sorted list.
   */
  public void removeDuplicates() {
    if (head == null || head.getNext() == null) {
      return;
    }
    Node<T> curr = head;
    while (curr.getNext() != null) {
      if (curr.getData().compareTo(curr.getNext().getData()) == 0) {
        curr.setNext(curr.getNext().getNext());
      } else {
        curr = curr.getNext();
      }
    }
  }

  /**
   * Reverse all the nodes in the linked list so that the last node becomes the first node.
   */
  public void reverseList() {
    if (head == null || head.getNext() == null) {
      return;
    } else {
      Node<T> curr = head;
      Node<T> prev = null;
      while (curr != null) {
        Node<T> newNext = curr.getNext();
        curr.setNext(prev);
        prev = curr;
        curr = newNext;
      }
      head = prev;
    }
  }

  /**
   * Create a new sorted list which is the merged from two original sorted lists. Assume the lists
   * are sorted in ascending order.
   */
  public LinkedListImpl<T> sortedMergeList(LinkedListImpl<T> otherList) {
    if (otherList == null) {
      return this;
    } else if (head == null) {
      return otherList;
    } else {
      LinkedListImpl<T> newList = new LinkedListImpl<T>();
      Node<T> curr1 = otherList.head;
      Node<T> curr2 = head;
      while (curr1 != null || curr2 != null) {
        if (curr2 == null || (curr1 != null && curr1.getData().compareTo(curr2.getData()) < 0)) {
          newList.addNodes(curr1.getData());
          curr1 = curr1.getNext();
        } else {
          newList.addNodes(curr2.getData());
          curr2 = curr2.getNext();
        }
      }

      return newList;
    }
  }

  private void addNodes(T data) {
    if (head == null) {
      head = new Node<T>(data);
    } else {
      Node<T> lastNode = head;
      while (lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(new Node<T>(data));
    }
  }

}
