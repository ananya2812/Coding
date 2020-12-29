package Medium;

import Easy.Node;

/*
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right
 * pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The
 * order of nodes in DLL must be same as Inorder of the given Binary The first node of Inorder
 * traversal (left most node in BT) must be head node of the DLL.
 */
public class BinaryTreeToDLL {

  static Node<Integer> head = null;
  static Node<Integer> prev = null;

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(10);
    root.left = new Node<>(12);
    root.right = new Node<>(15);
    root.left.left = new Node<>(25);
    root.left.right = new Node<>(30);
    root.right.left = new Node<>(36);

    convertBinaryTreeToDLL(root);

    printList(head);

  }

  private static void convertBinaryTreeToDLL(Node<Integer> root) {
    if (null == root) {
      return;
    }

    convertBinaryTreeToDLL(root.left);

    if (prev == null) {
      head = root;
    } else {
      root.left = prev;
      prev.right = root;
    }
    prev = root;

    convertBinaryTreeToDLL(root.right);

  }

  private static void printList(Node<Integer> head) {
    while (head != null) {
      System.out.print(head.data + ",");
      head = head.right;
    }
  }
}
