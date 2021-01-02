package Easy;

/*
 * Difference between sums of odd level and even level nodes of a Binary Given a Binary Tree, find
 * the difference between the sum of nodes at odd level and the sum of nodes at even level. Consider
 * root as level 1, left and right children of root as level 2 and so on.
 */
public class DifferenceBetweenSumOfOddLevelAndEvenLevel {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(5);
    root.left = new Node<>(2);
    root.right = new Node<>(6);
    root.left.left = new Node<>(1);
    root.left.right = new Node<>(4);
    root.left.right.left = new Node<>(3);
    root.right.right = new Node<>(8);
    root.right.right.right = new Node<>(9);
    root.right.right.left = new Node<>(7);
    System.out.println(getLevelDiff(root) + " is the required difference");
  }

  private static int getLevelDiff(Node<Integer> root) {
    if (null == root) {
      return 0;
    }
    return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
  }
}
