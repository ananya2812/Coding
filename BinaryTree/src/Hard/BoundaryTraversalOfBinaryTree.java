package Hard;

import Easy.Node;

public class BoundaryTraversalOfBinaryTree {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(20);
    root.left = new Node<>(8);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(12);
    root.left.right.left = new Node<>(10);
    root.left.right.right = new Node<>(14);
    root.right = new Node<>(22);
    root.right.right = new Node<>(25);
    printBoundary(root);
  }

  private static void printBoundary(Node<Integer> root) {
    if (null == root) {
      return;
    }
    // Print Root node
    System.out.print(root.data + ",");

    // Print Left Node
    printLeftNodes(root.left);

    // Print Leaf Node
    printLeafNode(root);

    // Print Right Node
    printRightNodes(root.right);
  }

  private static void printLeftNodes(Node<Integer> node) {
    if (null == node) {
      return;
    }
    if (node.left != null) {
      System.out.print(node.data + ",");
      printLeftNodes(node.left);
    } else if (node.right != null) {
      System.out.print(node.data + ",");
      printLeftNodes(node.right);
    }
  }

  private static void printLeafNode(Node<Integer> node) {
    if (null == node) {
      return;
    }
    printLeafNode(node.left);
    // Only Print Leaf Node in Inorder
    if (node.left == null && node.right == null) {
      System.out.print(node.data + ",");
    }

    printLeafNode(node.right);
  }

  private static void printRightNodes(Node<Integer> node) {
    if (null == node) {
      return;
    }
    if (node.right != null) {
      printRightNodes(node.right);
      System.out.print(node.data + ",");
    } else if (node.left != null) {
      printRightNodes(node.right);
      System.out.print(node.data + ",");
    }
  }
}
