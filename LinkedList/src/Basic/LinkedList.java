package Basic;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

  private Node<T> head = null;

  public LinkedList() {}

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
    if (head == null) {
      return head.getData();
    } else {
      T data = head.getData();
      head = head.getNext();
      return data;
    }
  }
}
