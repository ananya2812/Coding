package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import Easy.Node;

/*
 * Print reverse level order traversal. The idea is to print the last level first, then the second
 * last level, and so on. Like Level order traversal, every level is printed from left to right.
 */
public class ReverseLevelOrderTraversal {

  public static void main(String args[]) {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(5);

    System.out.println("Reverse Level Order traversal of binary tree is : ");
    reverseLevelOrder(root);
  }

  private static void reverseLevelOrder(Node<Integer> root) {
    if (null == root) {
      System.out.println("Empty Tree");
      return;
    }
    Queue<Node<Integer>> queue = new LinkedList<>();
    Stack<Node<Integer>> stack = new Stack<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node<Integer> temp = queue.poll();

      if (null != temp.right) {
        queue.add(temp.right);
      }

      if (null != temp.left) {
        queue.add(temp.left);
      }
      stack.add(temp);
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop().data + ",");
    }
  }

}
