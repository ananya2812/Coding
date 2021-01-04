package Easy;

/*
 * Count subtrees that sum up to a given value x only using single recursive function Given a binary
 * tree containing n nodes. The problem is to count subtrees having total node’s data sum equal to a
 * given value using only single recursive functions.
 */
public class CountSubtreesWithSumX {

  private static int count = 0;

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(5);
    root.left = new Node<>(-10);
    root.right = new Node<>(3);
    root.left.left = new Node<>(9);
    root.left.right = new Node<>(8);
    root.right.left = new Node<>(-4);
    root.right.right = new Node<>(7);

    int x = 7;

    System.out.println("Count = " + countSubtreesWithSumXUtil(root, x));
  }

  private static int countSubtreesWithSumXUtil(Node<Integer> root, int x) {
    if (null == root) {
      return 0;
    }
    int leftSubtreeSum = countSubtreesWithSumX(root.left, x);
    int rightSubtreeSum = countSubtreesWithSumX(root.right, x);
    if (leftSubtreeSum + rightSubtreeSum + root.data == x) {
      count++;
    }
    return count;
  }

  private static int countSubtreesWithSumX(Node<Integer> node, int x) {
    if (null == node) {
      return 0;
    }

    int leftSubtreeSum = countSubtreesWithSumX(node.left, x);
    int rightSubtreeSum = countSubtreesWithSumX(node.right, x);
    int sum = leftSubtreeSum + rightSubtreeSum + node.data;
    if (sum == x) {
      count++;
    }
    return sum;
  }
}
