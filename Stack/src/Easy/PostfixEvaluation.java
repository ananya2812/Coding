package Easy;

import java.util.Stack;

public class PostfixEvaluation {

  public static void main(String[] args) {
    String exp = "231*+9-";
    System.out.println("postfix evaluation: " + evaluatePostfix(exp));
  }

  private static Integer evaluatePostfix(String exp) {
    Stack<Integer> numStack = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
      Character ch = exp.charAt(i);
      if (Character.isDigit(ch)) {
        numStack.push(ch - '0');
      } else {
        Integer num1 = numStack.pop();
        Integer num2 = numStack.pop();

        switch (ch) {
          case '+':
            numStack.push(num1 + num2);
            break;
          case '-':
            numStack.push(num2 - num1);
            break;
          case '*':
            numStack.push(num1 * num2);
            break;
          case '/':
            numStack.push(num2 / num1);
            break;
        }
      }
    }
    return numStack.pop();
  }

}
