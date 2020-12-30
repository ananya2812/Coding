package Medium;

import Easy.Node;

/*
 * Construct Tree from given Inorder and Preorder traversals
 */
public class ConstructTreeFromInorderAndPreorder {

  static int preIndex = 0;

  public static void main(String args[]) {
    char in[] = new char[] {'D', 'B', 'E', 'A', 'F', 'C'};
    char pre[] = new char[] {'A', 'B', 'D', 'E', 'C', 'F'};
    Node<Character> root = buildTree(in, pre, 0, in.length - 1);

    System.out.println("Inorder traversal of constructed tree is : ");
    printInorder(root);
  }

  private static Node<Character> buildTree(char[] in, char[] pre, int inStart, int inEnd) {
    // Base Case -- When indexes cross each other
    if (inStart > inEnd) {
      return null;
    }

    Node<Character> newNode = new Node<>(pre[preIndex++]);

    int inIndex = search(in, inStart, inEnd, newNode.data);

    newNode.left = buildTree(in, pre, inStart, inIndex - 1);
    newNode.right = buildTree(in, pre, inIndex + 1, inEnd);

    return newNode;
  }

  private static int search(char[] arr, int start, int end, char data) {
    int i;
    for (i = start; i < end; i++) {
      if (data == arr[i]) {
        return i;
      }
    }
    return i;
  }

  private static void printInorder(Node<Character> node) {
    if (null == node) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + ",");
    printInorder(node.right);
  }
}
