package Medium;

import Easy.Node;

/*
 * Construct a Binary Tree from Postorder and Inorder
 */
public class ConstructTreeFromInorderAndPostorder {

  private static int postIndex = 0;

  public static void main(String[] args) {
    int in[] = new int[] {4, 8, 2, 5, 1, 6, 3, 7};
    int post[] = new int[] {8, 4, 5, 2, 6, 7, 3, 1};
    postIndex = post.length - 1;
    Node<Integer> root = buildTree(in, post, 0, in.length - 1);
    System.out.println("Preorder of the constructed tree : ");
    preorder(root);
  }

  private static void preorder(Node<Integer> node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + ",");
    preorder(node.left);
    preorder(node.right);
  }

  private static Node<Integer> buildTree(int[] in, int[] post, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }

    Node<Integer> newNode = new Node<>(post[postIndex--]);
    int inIndex = search(in, inStart, inEnd, newNode.data);

    newNode.right = buildTree(in, post, inIndex + 1, inEnd);
    newNode.left = buildTree(in, post, inStart, inIndex - 1);
    return newNode;
  }

  private static int search(int[] arr, int start, int end, int data) {
    int i;
    for (i = start; i < end; i++) {
      if (data == arr[i]) {
        return i;
      }
    }
    return i;
  }
}
