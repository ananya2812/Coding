package Easy;

/*
 * Given a Binary Tree, find the sum of all left leaves in it.
 */
public class LeftLeavesInBinaryTree {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(20);
    root.left = new Node<>(9);
    root.right = new Node<>(49);
    root.left.right = new Node<>(12);
    root.left.left = new Node<>(5);
    root.right.left = new Node<>(23);
    root.right.right = new Node<>(52);
    root.left.right.right = new Node<>(12);
    root.right.right.left = new Node<>(50);

    System.out.println("The sum of leaves is " + leftLeavesSum(root));
  }

  private static int leftLeavesSum(Node<Integer> root) {
    return leftLeavesSumUtil(root, 0, false);
  }

  private static int leftLeavesSumUtil(Node<Integer> node, int sum, Boolean isLeft) {
    if (node == null) {
      return sum;
    }

    if (node.left == null && node.right == null && isLeft) {
      return node.data + sum;
    }

    return leftLeavesSumUtil(node.left, sum, true) + leftLeavesSumUtil(node.right, sum, false);
  }
}
