package Basic;

public class Node<T extends Comparable<T>> {

  T data;
  Node<T> next;
  Node<T> prev;

  Node() {};

  Node(T data, Node<T> prev, Node<T> next) {
    this.data = data;
    this.prev = prev;
    this.next = next;
  }
}
