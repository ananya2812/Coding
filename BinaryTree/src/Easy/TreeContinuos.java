package Easy;

/*
 * A tree is a Continuous tree if in each root to leaf path, the absolute difference between keys of
 * two adjacent is 1.
 */
public class TreeContinuos {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(3);
    root.left = new Node<>(2);
    root.right = new Node<>(4);
    root.left.left = new Node<>(1);
    root.left.right = new Node<>(3);
    root.right.right = new Node<>(5);
    if (treeContinuous(root)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  private static Boolean treeContinuous(Node<Integer> root) {
    // Empty Tree
    if (root == null) {
      return true;
    }

    // Single Node Tree
    if (root.right == null && root.left == null) {
      return true;
    }
    // Tree with only right child
    if (root.left == null) {
      return (Math.abs(root.data - root.right.data) == 1) && treeContinuous(root.right);
    }

    // Tree with only left child
    if (root.right == null) {
      return (Math.abs(root.data - root.left.data) == 1) && treeContinuous(root.left);
    }

    return (Math.abs(root.data - root.right.data) == 1) && treeContinuous(root.right)
        && (Math.abs(root.data - root.left.data) == 1) && treeContinuous(root.left);
  }
}
