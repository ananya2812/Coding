package Easy;

/*
 * Write Code to Determine if Two Trees are Identical Two trees are identical when they have same
 * data and arrangement of data is also same.
 */
public class CheckIfTwoTreesAreIdentical {

  public static void main(String[] args) {
    Node<Integer> root1 = new Node<>(1);
    root1.left = new Node<>(2);
    root1.right = new Node<>(3);
    root1.left.left = new Node<>(4);
    root1.left.right = new Node<>(5);

    Node<Integer> root2 = new Node<>(1);
    root2.left = new Node<>(2);
    root2.right = new Node<>(3);
    root2.left.left = new Node<>(4);
    root2.left.right = new Node<>(5);

    if (identicalTrees(root1, root2)) {
      System.out.println("Both trees are identical");
    } else {
      System.out.println("Trees are not identical");
    }
  }

  private static Boolean identicalTrees(Node<Integer> root1, Node<Integer> root2) {
    if (null == root1 && null == root2) {
      return true;
    }

    if (null == root1 || null == root2) {
      return false;
    }

    return (root1.data == root2.data) && identicalTrees(root1.left, root2.left)
        && identicalTrees(root1.right, root2.right);
  }
}
