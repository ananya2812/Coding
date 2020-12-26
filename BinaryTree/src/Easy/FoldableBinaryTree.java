package Easy;

/*
 * Given a binary tree, find out if the tree can be folded or not.
 * 
 * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of
 * each other. An empty tree is considered as foldable.
 */
public class FoldableBinaryTree {

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();

    tree.root = new Node<Integer>(1);
    tree.root.left = new Node<Integer>(2);
    tree.root.right = new Node<Integer>(3);
    tree.root.right.left = new Node<Integer>(4);
    tree.root.left.right = new Node<Integer>(5);

    if (tree.IsFoldable(tree.root))
      System.out.println("Tree is Foldable");
    else
      System.out.println("Tree is Not Foldable");
  }
}


class BinaryTree {
  Node<Integer> root;

  /* Returns true if the given tree can be folded */
  boolean IsFoldable(Node<Integer> node) {
    if (null == node) {
      return true;
    }

    return isFoldableUtil(node.left, node.right);
  }

  boolean isFoldableUtil(Node<Integer> n1, Node<Integer> n2) {
    if (n1 == null && n2 == null) {
      return true;
    }
    if (n1 == null || n2 == null) {
      return false;
    }

    return isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right, n2.left);
  }

}


