package Basic;

public class DoublyLinkedList<T extends Comparable<T>> {

  Node<T> head = null;

  // Add a node at front
  public void push(T data) {
    Node<T> newNode = new Node<T>(data, null, null);
    newNode.next = head;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
  }

  // Add a node after a given node
  public void insertAfter(Node<T> prevNode, T data) {
    if (null == prevNode) {
      System.out.println("Previous Node cannot be null");
      return;
    }
    Node<T> newNode = new Node<T>(data, prevNode, prevNode.next);
    prevNode.next = newNode;
    if (newNode.next != null) {
      newNode.prev = newNode;
    }
  }

  // Add a node at end
  public void append(T data) {
    Node<T> newNode = new Node<T>(data, null, null);
    if (null == head) {
      head = newNode;
      return;
    }

    Node<T> lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }

    lastNode.next = newNode;
    newNode.prev = lastNode;
  }

  // Add a node before a given node
  public void insertBefore(Node<T> nextNode, T data) {
    if (null == nextNode) {
      System.out.println("Next Node cannot be null");
      return;
    }
    Node<T> newNode = new Node<T>(data, nextNode.prev, nextNode);
    nextNode.prev = newNode;
    if (null != newNode.prev) {
      newNode.prev.next = newNode;
    } else {
      head = newNode;
    }
  }

  public void printList(Node<T> headNode) {
    Node<T> currNode = headNode;
    while (currNode != null) {
      System.out.println(currNode.data);
      currNode = currNode.next;
    }
  }

}
