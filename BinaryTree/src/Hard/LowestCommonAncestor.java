package Hard;

import java.util.ArrayList;
import java.util.List;
import Easy.Node;

/*
 * Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to
 * find the least common ancestor.
 */
public class LowestCommonAncestor {

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.left = new Node<>(6);
    root.right.right = new Node<>(7);

    System.out.println("LCA(4, 5): " + findLCA(root, 4, 5));
    System.out.println("LCA(4, 6): " + findLCA(root, 4, 6));
    System.out.println("LCA(3, 4): " + findLCA(root, 3, 4));
    System.out.println("LCA(2, 4): " + findLCA(root, 2, 4));

  }

  private static int findLCA(Node<Integer> root, int n1, int n2) {
    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();

    if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
      System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
      System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
      return -1;
    }

    int i;
    for (i = 0; i < path1.size() && i < path2.size(); i++) {
      if (!path1.get(i).equals(path2.get(i)))
        break;
    }

    return path1.get(i - 1);
  }

  private static boolean findPath(Node<Integer> root, List<Integer> pathVal, int n1) {
    if (null == root) {
      return false;
    }

    pathVal.add(root.data);

    if (root.data == n1) {
      return true;
    }

    if (root.left != null && findPath(root.left, pathVal, n1)) {
      return true;
    }
    if (root.right != null && findPath(root.right, pathVal, n1)) {
      return true;
    }

    pathVal.remove(pathVal.size() - 1);
    return false;
  }
}
