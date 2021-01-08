package Hard;

import Easy.Node;

/*
 * Find the distance between two keys in a binary tree. The distance between two nodes is the
 * minimum number of edges to be traversed to reach one node from another.
 */
public class DistanceBetweenTwoNodes {

  public static void main(String[] args) {

    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.left = new Node<>(6);
    root.right.right = new Node<>(7);
    root.right.left.right = new Node<>(8);
    System.out.println("Dist(3, 9) = " + findDistance(root, 3, 9));
    System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
    System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
    System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
    System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
  }

  public static int findDistance(Node<Integer> root, int a, int b) {
    Node<Integer> lca = lca(root, a, b);
    int distanceA = findLevel(lca, a, 0);
    int distanceB = findLevel(lca, b, 0);
    return distanceA + distanceB;
  }

  public static Node<Integer> lca(Node<Integer> root, int a, int b) {
    if (root == null) {
      return null;
    }
    if (root.data == a || root.data == b) {
      return root;
    }
    Node<Integer> leftTree = lca(root.left, a, b);
    Node<Integer> rightTree = lca(root.right, a, b);

    if (leftTree != null && rightTree != null) {
      return root;
    }

    return (leftTree != null) ? leftTree : rightTree;
  }

  public static int findLevel(Node<Integer> lca, int a, int level) {
    if (lca == null) {
      return -1;
    }
    if (lca.data == a) {
      return level;
    }

    int leftTree = findLevel(lca.left, a, level + 1);
    if (leftTree == -1) {
      return findLevel(lca.right, a, level + 1);
    }
    return leftTree;
  }
}
