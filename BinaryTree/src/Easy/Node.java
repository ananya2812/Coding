package Easy;

public class Node<T> {
  T data;
  Node<T> left, right;

  Node(T item) {
    data = item;
    left = right = null;
  }

}
