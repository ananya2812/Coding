package Easy;

/*
 * Given a binary tree, check whether it is a mirror of itself.
 */
public class SymmetricTree {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<Integer>(2);
    root.right = new Node<Integer>(2);
    root.left.left = new Node<Integer>(3);
    root.left.right = new Node<Integer>(4);
    root.right.left = new Node<Integer>(4);
    root.right.right = new Node<Integer>(3);
    boolean output = isSymmetric(root);
    if (output == true)
      System.out.println("1");
    else
      System.out.println("0");
  }

  static boolean isSymmetric(Node<Integer> node) {
    return isMirror(node.left, node.right);
  }

  static boolean isMirror(Node<Integer> node1, Node<Integer> node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }
    return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
  }
}
