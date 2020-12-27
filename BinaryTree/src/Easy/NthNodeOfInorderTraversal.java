package Easy;

/*
 * Given the binary tree and you have to find out the n-th node of inorder traversal.
 */
public class NthNodeOfInorderTraversal {

  static int count = 0;

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(10);
    root.left = new Node<>(20);
    root.right = new Node<>(30);
    root.left.left = new Node<>(40);
    root.left.right = new Node<>(50);

    int n = 4;

    nthInorder(root, n);
  }

  private static void nthInorder(Node<Integer> root, int n) {
    if (root == null || n < 1) {
      return;
    }
    nthInorder(root.left, n);
    count++;
    if (count == n) {
      System.out.println(root.data);
    }
    nthInorder(root.right, n);
  }

}
