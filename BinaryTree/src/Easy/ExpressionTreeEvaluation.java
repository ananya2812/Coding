package Easy;

/*
 * Given a simple expression tree, consisting of basic binary operators i.e., + , – ,* and / and
 * some integers, evaluate the expression tree.
 */
public class ExpressionTreeEvaluation {

  public static void main(String[] args) {
    Node<String> root = new Node<>("+");
    root.left = new Node<>("*");
    root.left.left = new Node<>("5");
    root.left.right = new Node<>("-4");
    root.right = new Node<>("-");
    root.right.left = new Node<>("100");
    root.right.right = new Node<>("20");
    System.out.println(evaluate(root));

    Node<String> root2 = new Node<>("+");
    root2.left = new Node<>("*");
    root2.left.left = new Node<>("5");
    root2.left.right = new Node<>("4");
    root2.right = new Node<>("-");
    root2.right.left = new Node<>("100");
    root2.right.right = new Node<>("/");
    root2.right.right.left = new Node<>("20");
    root2.right.right.right = new Node<>("2");
    System.out.println(evaluate(root2));
  }

  private static int evaluate(Node<String> root) {
    if (root == null) {
      return 0;
    }
    // Leaf Node is an Operand Node
    if (root.left == null && root.right == null) {
      return Integer.parseInt(root.data);
    } else {
      // Operator Node
      int leftTreeEvaluated = evaluate(root.left);
      int rightTreeEvaluated = evaluate(root.right);

      switch (root.data) {
        case "+":
          return leftTreeEvaluated + rightTreeEvaluated;
        case "-":
          return leftTreeEvaluated - rightTreeEvaluated;
        case "*":
          return leftTreeEvaluated * rightTreeEvaluated;
        case "/":
          return leftTreeEvaluated / rightTreeEvaluated;
        case "^":
          return leftTreeEvaluated ^ rightTreeEvaluated;
      }
    }
    return Integer.MAX_VALUE;
  }
}
