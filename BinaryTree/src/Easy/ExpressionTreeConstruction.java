package Easy;

import java.util.Stack;

/*
 * The expression tree is a binary tree in which each internal node corresponds to the operator and
 * each leaf node corresponds to the operand
 */
public class ExpressionTreeConstruction {

  public static void main(String args[]) {

    ExpressionTree et = new ExpressionTree();
    String postfix = "ab+ef*g*-";
    char[] charArray = postfix.toCharArray();
    Node<Character> root = et.constructTree(charArray);
    System.out.println("infix expression is");
    et.inorder(root);
  }
}


class ExpressionTree {

  boolean isOperator(char c) {
    if ((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '^')) {
      return true;
    }
    return false;
  }

  Node<Character> constructTree(char[] charArray) {
    if (charArray.length == 0) {
      return null;
    }

    Stack<Node<Character>> stack = new Stack<>();
    for (int i = 0; i < charArray.length; i++) {
      Node<Character> newNode = new Node<Character>(charArray[i]);
      if (isOperator(charArray[i])) {
        newNode.right = stack.pop();
        newNode.left = stack.pop();
      }
      stack.push(newNode);
    }
    return stack.pop();
  }

  void inorder(Node<Character> temp) {
    if (temp == null) {
      return;
    }
    inorder(temp.left);
    System.out.print(temp.data);
    inorder(temp.right);
  }
}


