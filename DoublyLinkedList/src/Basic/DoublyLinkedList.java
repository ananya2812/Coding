package Basic;

public class DoublyLinkedList<T extends Comparable<T>> {

  private Node<T> head = null;

  public Node<T> getHead() {
    return head;
  }

  public void setHead(Node<T> head) {
    this.head = head;
  }

  // Add a node at front
  public void push(T data) {
    Node<T> newNode = new Node<T>(data, null, null);
    newNode.setNext(head);
    if (head != null) {
      head.setPrev(newNode);
    }
    head = newNode;
  }

  // Add a node after a given node
  public void insertAfter(Node<T> prevNode, T data) {
    if (null == prevNode) {
      System.out.println("Previous Node cannot be null");
      return;
    }
    Node<T> newNode = new Node<T>(data, prevNode, prevNode.getNext());
    prevNode.setNext(newNode);
    if (newNode.getNext() != null) {
      newNode.setPrev(newNode);
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
    while (lastNode.getNext() != null) {
      lastNode = lastNode.getNext();
    }

    lastNode.setNext(newNode);
    newNode.setPrev(lastNode);
  }

  // Add a node before a given node
  public void insertBefore(Node<T> nextNode, T data) {
    if (null == nextNode) {
      System.out.println("Next Node cannot be null");
      return;
    }
    Node<T> newNode = new Node<T>(data, nextNode.getPrev(), nextNode);
    nextNode.setPrev(newNode);
    if (null != newNode.getPrev()) {
      newNode.getPrev().setNext(newNode);
    } else {
      head = newNode;
    }
  }

  public void printList(Node<T> headNode) {
    Node<T> currNode = headNode;
    while (currNode != null) {
      System.out.println(currNode.getData());
      currNode = currNode.getNext();
    }
  }

  public void deleteNode(Node<T> deleteNode) {
    if (null == head || deleteNode == null) {
      return;
    }
    if (head == deleteNode) {
      head = head.getNext();
      return;
    }

    if (null != deleteNode.getPrev()) {
      deleteNode.getPrev().setNext(deleteNode.getNext());
    }
    if (null != deleteNode.getNext()) {
      deleteNode.getNext().setPrev(deleteNode.getPrev());
    }
  }

}
