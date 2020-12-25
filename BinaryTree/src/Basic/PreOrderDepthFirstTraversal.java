package Basic;

/*
 * Pre-Order Depth First Traversal
 */
public class PreOrderDepthFirstTraversal {

  static Node root;

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Pre-Order Depth First Traversal:");
    preorderdepthFirstTraversal(root);
  }

  static void preorderdepthFirstTraversal(Node root) {
    if (null == root) {
      return;
    }
    System.out.print(root.key + ",");
    preorderdepthFirstTraversal(root.left);
    preorderdepthFirstTraversal(root.right);
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
