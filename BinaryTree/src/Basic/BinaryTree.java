package Basic;

public class BinaryTree {

  Node root;

  BinaryTree(int key) {
    root = new Node(key);
  }

  BinaryTree() {
    root = null;
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(); 
    
    tree.root = new Node(1); 

    /* 

          1 
        /   \ 
      null  null     */

    tree.root.left = new Node(2); 
    tree.root.right = new Node(3); 

    /*  
           1 
         /   \ 
        2      3 
      /    \    /  \ 
    null null null null  */


    tree.root.left.left = new Node(4); 
    /* 
                1 
            /       \ 
           2          3 
         /   \       /  \ 
        4    null  null  null 
       /   \ 
      null null 
     */
} 
  
}
class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
