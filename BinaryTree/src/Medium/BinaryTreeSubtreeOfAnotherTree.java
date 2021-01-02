package Medium;

import Easy.Node;

/*
 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree
 * T is a tree S consisting of a node in T and all of its descendants in T. The subtree
 * corresponding to the root node is the entire tree; the subtree corresponding to any other node is
 * called a proper subtree.
 */
public class BinaryTreeSubtreeOfAnotherTree {

  public static void main(String args[]) {
    Node<Character> T = new Node<>('a');
    T.left = new Node<>('b');
    T.right = new Node<>('d');
    T.left.left = new Node<>('c');
    T.right.right = new Node<>('e');

    Node<Character> S = new Node<>('a');
    S.left = new Node<>('b');
    S.right = new Node<>('d');
    S.left.left = new Node<>('c');

    if (isSubtree(T, S)) {
      System.out.println("Yes, S is a subtree of T");
    } else {
      System.out.println("No, S is not a subtree of T");
    }
  }

  private static Boolean isSubtree(Node<Character> T, Node<Character> S) {
    return null != T && (isEqual(T, S) || isSubtree(T.right, S) || isSubtree(T.left, S));
  }

  private static Boolean isEqual(Node<Character> T, Node<Character> S) {
    if (T == null && S == null) {
      return true;
    }
    if (T == null || S == null) {
      return false;
    }

    return T.data == S.data && isEqual(T.left, S.left) && isEqual(T.right, S.right);
  }
}
