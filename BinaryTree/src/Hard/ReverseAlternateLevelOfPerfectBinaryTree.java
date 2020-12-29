package Hard;

import Easy.Node;

/*
 * Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree.
 */
public class ReverseAlternateLevelOfPerfectBinaryTree {

  public static void main(String args[]) {
    Node<Character> root = new Node<>('a');
    root.left = new Node<>('b');
    root.right = new Node<>('c');
    root.left.left = new Node<>('d');
    root.left.right = new Node<>('e');
    root.right.left = new Node<>('f');
    root.right.right = new Node<>('g');
    root.left.left.left = new Node<>('h');
    root.left.left.right = new Node<>('i');
    root.left.right.left = new Node<>('j');
    root.left.right.right = new Node<>('k');
    root.right.left.left = new Node<>('l');
    root.right.left.right = new Node<>('m');
    root.right.right.left = new Node<>('n');
    root.right.right.right = new Node<>('o');

    System.out.print("\nInorder Traversal of given tree\n");
    printInorder(root);

    reverseAlternate(root);

    System.out.print("\n\nInorder Traversal of modified tree\n");
    printInorder(root);
  }

  private static void printInorder(Node<Character> root) {
    if (null == root) {
      return;
    }
    printInorder(root.left);
    System.out.print(root.data + ",");
    printInorder(root.right);
  }

  private static void reverseAlternate(Node<Character> root) {
    if (null == root) {
      return;
    }
    reverseAlternateUtil(root.left, root.right, 0);
  }

  private static void reverseAlternateUtil(Node<Character> node1, Node<Character> node2,
      int level) {

    if (null == node1 || null == node2) {
      return;
    }

    if (level % 2 == 0) {
      char temp = node1.data;
      node1.data = node2.data;
      node2.data = temp;
    }

    reverseAlternateUtil(node1.left, node2.right, level + 1);
    reverseAlternateUtil(node1.right, node2.left, level + 1);
  }
}
