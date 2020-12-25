package Basic;

/*
 * In-Order Depth First Traversal
 */
public class InOrderDepthFirstTraversal {

  static Node root;

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("In-Order Depth First Traversal:");
    inOrderdepthFirstTraversal(root);
  }

  static void inOrderdepthFirstTraversal(Node root) {
    if (null == root) {
      return;
    }
    
    inOrderdepthFirstTraversal(root.left);
    System.out.print(root.key + ",");
    inOrderdepthFirstTraversal(root.right);
  }

  static class Node {
    int key;
    Node left, right;

    Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }
}
