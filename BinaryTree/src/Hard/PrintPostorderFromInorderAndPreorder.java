package Hard;

import java.util.Arrays;

/*
 * Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.
 */
public class PrintPostorderFromInorderAndPreorder {

  public static void main(String args[]) {
    int in[] = {4, 2, 5, 1, 3, 6};
    int pre[] = {1, 2, 4, 5, 3, 6};
    System.out.println("Postorder traversal ");
    printPostorder(in, pre, in.length);
  }

  private static void printPostorder(int[] inorder, int[] preorder, int n) {

    // Find index of root in inorder
    int rootIndex = search(inorder, preorder[0], n);

    // If Left Subtree is not empty, print left subtree
    if (rootIndex != 0) {
      printPostorder(inorder, Arrays.copyOfRange(preorder, 1, n), rootIndex);
    }

    // If Right Subtree is not empty, print right subtree
    if (rootIndex != n - 1) {
      printPostorder(Arrays.copyOfRange(inorder, rootIndex + 1, n),
          Arrays.copyOfRange(preorder, rootIndex + 1, n), n - rootIndex - 1);
    }

    System.out.print(preorder[0] + ",");
  }

  private static int search(int[] arr, int data, int n) {
    for (int i = 0; i < n; i++) {
      if (arr[i] == data) {
        return i;
      }
    }
    return -1;
  }
}
