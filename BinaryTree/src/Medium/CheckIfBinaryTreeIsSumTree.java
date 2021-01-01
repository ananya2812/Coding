package Medium;

import Easy.Node;

/*
 * Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a
 * Binary Tree where the value of a Node<> is equal to the sum of the Node<>s present in its left
 * subtree and right sub An empty tree is SumTree and sum of an empty tree can be considered as 0. A
 * leaf Node<> is also considered as Sum
 */
public class CheckIfBinaryTreeIsSumTree {

  public static void main(String[] args) {
    Node<Integer> root = new Node<>(26);
    root.left = new Node<>(10);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    root.left.right = new Node<>(6);
    root.right.right = new Node<>(3);
    if (isSumTreeOptimal(root)) {
      System.out.println("The given tree is a SumTree");
    } else {
      System.out.println("The given tree is not a SumTree");
    }
  }

  private static Boolean isSumTree(Node<Integer> root) {
    if (null == root || (root.left == null && root.right == null)) {
      return true;
    }
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);
    if ((root.data == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right)) {
      return true;
    }
    return false;
  }

  private static int sum(Node<Integer> root) {
    if (null == root) {
      return 0;
    }
    return sum(root.left) + root.data + sum(root.right);
  }

  private static Boolean isLeaf(Node<Integer> node) {
    if (node == null) {
      return false;
    } else if (node.left == null && node.right == null) {
      return true;
    }
    return false;
  }

  private static Boolean isSumTreeOptimal(Node<Integer> root) {
    if (null == root || isLeaf(root)) {
      return true;
    }

    int leftSum = 0;
    int rightSum = 0;

    if (isSumTree(root.left) && isSumTree(root.right)) {

      if (root.left == null) {
        leftSum = 0;
      } else if (isLeaf(root.left)) {
        leftSum = root.left.data;
      } else {
        leftSum = root.left.data * 2;
      }

      if (root.right == null) {
        rightSum = 0;
      } else if (isLeaf(root.right)) {
        rightSum = root.right.data;
      } else {
        rightSum = root.right.data * 2;
      }

      if (root.data == rightSum + leftSum) {
        return true;
      } else {
        return false;
      }

    }
    return false;
  }
}
