package Easy;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, write a function to get the maximum width of the given tree. Width of a tree
 * is maximum of widths of all levels.
 */
public class MaximumWidthOfBinaryTree {

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.right = new Node<>(8);
    root.right.right.left = new Node<>(6);
    root.right.right.right = new Node<>(7);
    System.out.println("Maximum width = " + maxWidth(root));
  }

  private static int maxWidth(Node<Integer> root) {
    if (null == root) {
      return 0;
    }
    int maxWidth = 0;
    Queue<Node<Integer>> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int count = queue.size();
      maxWidth = Math.max(count, maxWidth);
      while (count-- > 0) {
        Node<Integer> temp = queue.poll();
        if (null != temp.left) {
          queue.add(temp.left);
        }
        if (null != temp.right) {
          queue.add(temp.right);
        }
      }
    }

    return maxWidth;
  }
}
