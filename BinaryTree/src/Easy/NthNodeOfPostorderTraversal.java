package Easy;

/*
 * Given a Binary tree and a number N, write a program to find the N-th node in the Postorder
 * traversal of the given Binary tree.
 */
public class NthNodeOfPostorderTraversal {

  static int count = 0;

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(25);
    root.left = new Node<>(20);
    root.right = new Node<>(30);
    root.left.left = new Node<>(18);
    root.left.right = new Node<>(22);
    root.right.left = new Node<>(24);
    root.right.right = new Node<>(32);

    int N = 6;
    nthPostorderNode(root, N);
  }

  private static void nthPostorderNode(Node<Integer> root, int N) {
    if (null == root || N < 1) {
      return;
    }

    nthPostorderNode(root.left, N);
    nthPostorderNode(root.right, N);
    count++;
    if (N == count) {
      System.out.println(root.data);
    }
  }
}
