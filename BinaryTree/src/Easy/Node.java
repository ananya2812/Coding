package Easy;

public class Node<T> {
  public T data;
  public Node<T> left, right;

  public Node(T item) {
    data = item;
    left = right = null;
  }

}
