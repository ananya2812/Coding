package Hard;

import Easy.Node;

/*
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the
 * 
 */
public class MaximumPathSum {

  static int maxSum = Integer.MIN_VALUE;

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(10);
    root.left = new Node<>(2);
    root.right = new Node<>(10);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(1);
    root.right.right = new Node<>(-25);
    root.right.right.left = new Node<>(3);
    root.right.right.right = new Node<>(4);
    findMaxSum(root);
    System.out.println("Maximum path sum is : " + maxSum);
  }

  private static int findMaxSum(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    int lMax = findMaxSum(root.left);
    int rMax = findMaxSum(root.right);


    int maxBranchOrNode = Math.max(Math.max(lMax, rMax) + root.data, root.data);
    int maxSingleItr = Math.max(maxBranchOrNode, lMax + rMax + root.data);
    maxSum = Math.max(maxSingleItr, maxSum);

    return maxBranchOrNode;
  }

}
