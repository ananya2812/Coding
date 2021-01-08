package Hard;

import Easy.Node;

public class LowestCommonAncestor2 {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.left = new Node<>(6);
    root.right.right = new Node<>(7);
    System.out.println("LCA(4, 5) = " + findLCA(root, 4, 5).data);
    System.out.println("LCA(4, 6) = " + findLCA(root, 4, 6).data);
    System.out.println("LCA(3, 4) = " + findLCA(root, 3, 4).data);
    System.out.println("LCA(2, 4) = " + findLCA(root, 2, 4).data);
  }

  private static Node<Integer> findLCA(Node<Integer> node, int n1, int n2) {
    if (null == node) {
      return node;
    }
    if (node.data == n1 || node.data == n2) {
      return node;
    }

    Node<Integer> leftTree = findLCA(node.left, n1, n2);
    Node<Integer> rightTree = findLCA(node.right, n1, n2);

    if (null != leftTree && null != rightTree) {
      return node;
    }

    return (leftTree != null) ? leftTree : rightTree;

  }
}
