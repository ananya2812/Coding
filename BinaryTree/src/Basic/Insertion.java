package Basic;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree and a key, insert the key into the binary tree at the first position
 * available in level order.
 */
public class Insertion {

  static Node root;

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Inorder traversal before insertion:");
    inorder(root);

    int key = 12;
    insert(root, key);

    System.out.print("\nInorder traversal after insertion:");
    inorder(root);
  }

  static void insert(Node root, int key) {

    if (null == root) {
      root = new Node(key);
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      Node front = queue.poll();
      if (front.left == null) {
        front.left = new Node(key);
        return;
      } else {
        queue.offer(front.left);
      }
      if (front.right == null) {
        front.right = new Node(key);
        return;
      } else {
        queue.offer(front.right);
      }
    }

  }

  static void inorder(Node temp) {
    if (temp == null) {
      return;
    }
    inorder(temp.left);
    System.out.print(temp.key + " ");
    inorder(temp.right);
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
