package Easy;

public class FoldableBinaryTree {

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();

    /* 
    1 
  /   \ 
 2     3 
  \    / 
   4  5 
     */
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.right.left = new Node(4);
    tree.root.left.right = new Node(5);

    if (tree.IsFoldable(tree.root))
      System.out.println("Tree is Foldable");
    else
      System.out.println("Tree is Not Foldable");
  }
}


class BinaryTree {
  Node root;

  /* Returns true if the given tree can be folded */
  boolean IsFoldable(Node node) {
    if (null == node) {
      return true;
    }

    return isFoldableUtil(node.left, node.right);
  }

  boolean isFoldableUtil(Node n1, Node n2) {
    if (n1 == null && n2 == null) {
      return true;
    }
    if (n1 == null || n2 == null) {
      return false;
    }

    return isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right, n2.left);
  }

}


class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}
