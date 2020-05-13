package gfg13MAY;

public class Node<T extends Comparable<T>> {

  T data;
  Node<T> next;

  Node(T data) {
    this.data = data;
    setNext(null);
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

}
