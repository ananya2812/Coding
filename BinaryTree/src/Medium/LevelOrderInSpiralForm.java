package Medium;

import java.util.Stack;
import Easy.Node;

public class LevelOrderInSpiralForm {

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(7);
    root.left.right = new Node<>(6);
    root.right.left = new Node<>(5);
    root.right.right = new Node<>(4);
    System.out.println("Spiral Order traversal of Binary Tree is ");
    printSpiral(root);
  }

  private static void printSpiral(Node<Integer> root) {
    if (root == null) {
      return;
    }

    Stack<Node<Integer>> s1 = new Stack<>();
    Stack<Node<Integer>> s2 = new Stack<>();
    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.isEmpty()) {
        Node<Integer> temp = s1.pop();
        System.out.print(temp.data + ",");

        if (temp.right != null) {
          s2.push(temp.right);
        }

        if (temp.left != null) {
          s2.push(temp.left);
        }
      }
      while (!s2.isEmpty()) {
        Node<Integer> temp = s2.pop();
        System.out.print(temp.data + ",");

        if (temp.left != null) {
          s1.push(temp.left);
        }
        if (temp.right != null) {
          s1.push(temp.right);
        }

      }
    }
  }
}
