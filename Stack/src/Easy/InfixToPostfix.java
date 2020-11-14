package Easy;

import java.util.Stack;

/*
 * Convert Infix to Postfix
 */
public class InfixToPostfix {

  public static void main(String[] args) {
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(infixToPostfix(exp));
  }

  private static String infixToPostfix(String exp) {
    String result = "";
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
      char input = exp.charAt(i);
      if (Character.isLetterOrDigit(input)) {
        result += input;
      } else if (input == '(') {
        stack.push(input);
      } else if (input == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result += stack.pop();
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(input) <= precedence(stack.peek())) {
          result += stack.pop();
        }
        stack.push(input);
      }
    }
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }

  private static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

}

