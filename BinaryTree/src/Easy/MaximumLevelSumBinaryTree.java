package Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a Binary Tree having positive and negative nodes, the task is to find the maximum sum level
 * in it.
 */
public class MaximumLevelSumBinaryTree {

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.right = new Node<>(8);
    root.right.right.left = new Node<>(6);
    root.right.right.right = new Node<>(7);
    System.out.println("Maximum level sum is " + maxLevelSum(root));
  }

  private static int maxLevelSum(Node<Integer> root) {
    if (null == root) {
      return 0;
    }
    int maxLevelSum = root.data;

    Queue<Node<Integer>> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int count = queue.size();
      int sum = 0;
      while (count-- > 0) {

        Node<Integer> node = queue.poll();
        sum += node.data;

        if (null != node.left) {
          queue.offer(node.left);
        }

        if (null != node.right) {
          queue.offer(node.right);
        }
      }
      maxLevelSum = Math.max(sum, maxLevelSum);
    }
    return maxLevelSum;
  }
}
