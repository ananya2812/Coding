package Easy;

/*
 * Write a Program to Find the Maximum Depth or Height of a Tree Given a binary tree, find height of
 * it. Height of empty tree is 0
 */
public class MaximumDepthOfTree {

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);

    System.out.println("Height of tree is : " + maxDepth(root));
  }

  private static int maxDepth(Node<Integer> root) {
    if (null == root) {
      return 0;
    }
    int leftSubtreeHeight = maxDepth(root.left);
    int rightSubtreeHeight = maxDepth(root.right);

    return Math.max(1 + leftSubtreeHeight, 1 + rightSubtreeHeight);
  }
}
