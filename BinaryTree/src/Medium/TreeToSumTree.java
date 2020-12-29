package Medium;

import Easy.Node;

/*
 * Given a Binary Tree where each node has positive and negative values. Convert this to a tree
 * where each node contains the sum of the left and right sub trees in the original tree. The values
 * of leaf nodes are changed to 0.
 */
public class TreeToSumTree {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(10);
    root.left = new Node<>(-2);
    root.right = new Node<>(6);
    root.left.left = new Node<>(8);
    root.left.right = new Node<>(-4);
    root.right.left = new Node<>(7);
    root.right.right = new Node<>(5);

    toSumTree(root);

    System.out.println("Inorder Traversal of the resultant tree is:");
    printInorder(root);
  }

  private static int toSumTree(Node<Integer> node) {
    if (null == node) {
      return 0;
    }
    int oldValue = node.data;
    node.data = toSumTree(node.left) + toSumTree(node.right);
    return oldValue + node.data;
  }

  private static void printInorder(Node<Integer> node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

}
