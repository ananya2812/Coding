package Basic;

/*
 * Post-Order Depth First Traversal
 */
public class PostOrderDepthFirstTraversal {

  static Node root;

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Post-Order Depth First Traversal:");
    postOrderdepthFirstTraversal(root);
  }

  static void postOrderdepthFirstTraversal(Node root) {
    if (null == root) {
      return;
    }
    
    postOrderdepthFirstTraversal(root.left);
    postOrderdepthFirstTraversal(root.right);
    System.out.print(root.key + ",");
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
