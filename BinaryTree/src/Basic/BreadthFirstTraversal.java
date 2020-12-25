package Basic;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Level Order Traversal
 */
public class BreadthFirstTraversal {

  static Node root;

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Breadth First Traversal:");
    breadthFirstTraversal(root);
  }

  static void breadthFirstTraversal(Node root) {
    if (null == root) {
      System.out.println("Empty Tree");
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      Node front = queue.poll();
      System.out.print(front.key + ",");
      if (front.left != null) {
        queue.offer(front.left);
      }
      if (front.right != null) {
        queue.offer(front.right);
      }
    }
  }

  static class Node {
    int key;
    Node left, right;

    Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }
}
