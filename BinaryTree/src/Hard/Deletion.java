package Hard;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom (i.e.
 * the deleted node is replaced by bottom most and rightmost node)
 */
public class Deletion {

  static Node root;

  static class Node {
    int key;
    Node left, right;

    Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.left.right = new Node(12);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.println("\nInorder traversal before deletion:");
    inorder(root);

    int key = 8;
    delete(key);

    System.out.println("\nInorder traversal after deletion:");
    inorder(root);
  }

  static void delete(int key) {
    if (null == root) {
      return;
    }

    if (null == root.left && null == root.right) {
      if (root.key == key) {
        root = null;
      }
      return;
    }
    Node rightmostDeepestNode = null, keyNode = null;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      rightmostDeepestNode = queue.poll();
      if (rightmostDeepestNode.key == key) {
        keyNode = rightmostDeepestNode;
      }
      if (rightmostDeepestNode.left != null) {
        queue.offer(rightmostDeepestNode.left);
      }

      if (rightmostDeepestNode.right != null) {
        queue.offer(rightmostDeepestNode.right);
      }
    }
    if (keyNode != null) {
      int temp = rightmostDeepestNode.key;
      deleteDeepest(rightmostDeepestNode);
      keyNode.key = temp;
    }
  }

  static void deleteDeepest(Node delNode) {
    Node temp = root;
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      temp = queue.poll();

      if (temp == delNode) {
        temp = null;
        return;
      }
      if (temp.right != null) {
        if (temp.right == delNode) {
          temp.right = null;
          return;
        } else {
          queue.add(temp.right);
        }
      }

      if (temp.left != null) {
        if (temp.left == delNode) {
          temp.left = null;
          return;
        } else {
          queue.add(temp.left);
        }
      }
    }
  }


  static void inorder(Node temp) {
    if (temp == null) {
      return;
    }
    inorder(temp.left);
    System.out.print(temp.key + ",");
    inorder(temp.right);
  }
}
