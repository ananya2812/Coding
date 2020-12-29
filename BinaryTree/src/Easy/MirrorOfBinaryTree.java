package Easy;

public class MirrorOfBinaryTree {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);

    System.out.println("Inorder traversal of input tree is :");
    inOrder(root);
    System.out.println("");

    mirror(root);

    System.out.println("Inorder traversal of binary tree is : ");
    inOrder(root);
  }

  private static void inOrder(Node<Integer> node) {
    if (null == node) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.data + ",");
    inOrder(node.right);
  }

  private static void mirror(Node<Integer> node) {
    if (null == node.left && null == node.right) {
      return;
    }

    mirror(node.left);
    mirror(node.right);

    Node<Integer> temp = node.right;
    node.right = node.left;
    node.left = temp;
  }
}
