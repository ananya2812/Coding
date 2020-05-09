package Basic;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

  private Node<T> head = null;

  public int countNodes() {
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

  public void addNodes(T data) {
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

  public T popElement() {
    if (head != null) {
      T data = head.getData();
      head = head.getNext();
      return data;
    }
    return null;
  }

  public void printNodes() {
    Node<T> node = head;
    while (node != null) {
      System.out.println(node.getData());
      node = node.getNext();
    }
  }

  public void deleteLinkedList() {
    head = null;
  }

  /**
   * Insert at the nth position in the list. Return if the number of nodes is less than n.
   */
  public void insertNth(int n, T data) {
    if (n < 0 || n > countNodes()) {
      return;
    } else if (n == 0) {
      Node<T> newNode = new Node<T>(data);
      newNode.setNext(head);
      head = newNode;
    } else {
      Node<T> currNode = head;
      int count = 0;
      while (count < n - 1) {
        count++;
        currNode = currNode.getNext();
      }
      Node<T> newNode = new Node<T>(data);
      newNode.setNext(currNode.getNext());
      currNode.setNext(newNode);
    }
  }

  /**
   * Append the nodes of the other list to the end of the current list.
   */
  public void appendList(LinkedList<T> ll) {
    if (ll.head == null) {
      return;
    } else {
      Node<T> lastNode = head;
      while (lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(ll.head);
    }
  }

  /**
   * Move the head element or the first element from this list to the destination linked list as the
   * destination's new head node.
   */
  public void changeHead(LinkedList<T> destinationList) {
    T currHead = popElement();
    if (currHead == null) {
      return;
    } else if (destinationList.head == null) {
      destinationList.addNodes(currHead);
    } else {
      Node<T> newHeadNode = new Node<T>(currHead);
      newHeadNode.setNext(destinationList.head.getNext());
      destinationList.head = newHeadNode;
    }
  }

}
