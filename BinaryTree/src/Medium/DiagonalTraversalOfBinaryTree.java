package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import Easy.Node;

/*
 * Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal
 * elements in a binary tree belonging to the same line.
 */
public class DiagonalTraversalOfBinaryTree {

  public static void main(String[] args) {

    Node<Integer> root = new Node<>(8);
    root.left = new Node<>(3);
    root.right = new Node<>(10);
    root.left.left = new Node<>(1);
    root.left.right = new Node<>(6);
    root.right.right = new Node<>(14);
    root.right.right.left = new Node<>(13);
    root.left.right.left = new Node<>(4);
    root.left.right.right = new Node<>(7);

    diagonalPrint(root);
  }

  private static void diagonalPrint(Node<Integer> root) {
    Map<Integer, List<Node<Integer>>> slopeMap = new HashMap<>();
    diagonalPrintUtil(root, 0, slopeMap);
    for (Entry<Integer, List<Node<Integer>>> entry : slopeMap.entrySet()) {
      List<Node<Integer>> listNodes = entry.getValue();
      for (Node<Integer> node : listNodes) {
        System.out.print(node.data + ",");
      }
      System.out.println();
    }
  }

  private static void diagonalPrintUtil(Node<Integer> node, int slope,
      Map<Integer, List<Node<Integer>>> slopeMap) {
    if (null == node) {
      return;
    }

    List<Node<Integer>> sameSlopeNodes = slopeMap.get(slope);
    if (null == sameSlopeNodes) {
      sameSlopeNodes = new ArrayList<>();
    }
    sameSlopeNodes.add(node);
    slopeMap.put(slope, sameSlopeNodes);

    diagonalPrintUtil(node.left, slope + 1, slopeMap);
    diagonalPrintUtil(node.right, slope, slopeMap);
  }
}
