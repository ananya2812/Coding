package Hard;

import Easy.Node;

/*
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given number. Return false if no such path can
 * be found.
 */
public class RootToLeafPathSumEqualToX {

  public static void main(String args[]) {
    int sum = 21;
    Node<Integer> root = new Node<>(10);
    root.left = new Node<>(8);
    root.right = new Node<>(2);
    root.left.left = new Node<>(3);
    root.left.right = new Node<>(5);
    root.right.left = new Node<>(2);

    if (hasPathSum(root, sum)) {
      System.out.println("There is a root to leaf path with sum " + sum);
    } else {
      System.out.println("There is no root to leaf path with sum " + sum);
    }
  }

  private static boolean hasPathSum(Node<Integer> root, int sum) {
    if (null == root) {
      return (sum == 0);
    }

    return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
  }

}
