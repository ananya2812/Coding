package Medium;

import java.util.ArrayList;
import java.util.List;
import Easy.Node;

/*
 * Given a binary tree containing n nodes. The problem is to replace each node in the binary tree
 * with the sum of its inorder predecessor and inorder successor.
 */
public class ReplaceNodeWithInorderPredecessorAndSuccessor {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);
    root.right.left = new Node<>(6);
    root.right.right = new Node<>(7);

    System.out.println("Preorder Traversal before tree modification:");
    preorderTraversal(root);

    replaceNodeWithSumUtil(root);

    System.out.println("\nPreorder Traversal after tree modification:");
    preorderTraversal(root);
  }

  private static void preorderTraversal(Node<Integer> root) {
    if (null == root) {
      return;
    }
    System.out.print(root.data + ",");
    preorderTraversal(root.left);
    preorderTraversal(root.right);
  }

  private static void replaceNodeWithSumUtil(Node<Integer> root) {
    List<Integer> inorderList = new ArrayList<>();
    inorderList.add(0);
    inorder(root, inorderList);
    inorderList.add(0);
    replaceNodeWithSum(root, inorderList);
  }

  private static void replaceNodeWithSum(Node<Integer> root, List<Integer> inorderList) {
    if (root == null) {
      return;
    }
    replaceNodeWithSum(root.left, inorderList);
    int nodeIndex = inorderList.indexOf(root.data);
    root.data = inorderList.get(nodeIndex - 1) + inorderList.get(nodeIndex + 1);
    replaceNodeWithSum(root.right, inorderList);
  }

  private static void inorder(Node<Integer> root, List<Integer> arrList) {
    if (null == root) {
      return;
    }
    inorder(root.left, arrList);
    arrList.add(root.data);
    inorder(root.right, arrList);
  }
}
